package com.hnisc.community.service.impl;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.exception.GeneralErrorCodeImpl;
import com.hnisc.community.exception.GeneralException;
import com.hnisc.community.mapper.PostMapper;
import com.hnisc.community.mapper.UserMapper;
import com.hnisc.community.model.Post;
import com.hnisc.community.model.PostExample;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author lh141
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;


    @Override
    public PageDTO findPostList(Integer page, Integer size) {

        PageDTO pageDTO = new PageDTO();
        //帖子的总条数
        Integer totalCount = (int) postMapper.countByExample(new PostExample());

        /**
         * 如果帖子总条数取余每页显示条数为0，则总页数为帖总条数除以每页显示数
         * 如果帖子总条数取余每页显示条数不为0，则总页数为帖总条数除以每页显示数再加一
         */
        Integer totalPage;

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        //防止传入数据库的page超过合理范围
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }

        pageDTO.setPage(totalPage, page);

        Integer offset = size * (page - 1);
        if (offset < 0) {
            offset = 0;
        }
        List<Post> posts = postMapper.selectByExampleWithRowbounds(new PostExample(), new RowBounds(offset, size));
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getCreatorId());
            PostDTO postDTO = new PostDTO();
            //通过spring内置的BeanUtils中的copyProperties方法将post的值覆盖postDTO
            BeanUtils.copyProperties(post, postDTO);
            //设置postDTO中user的值
            postDTO.setUser(user);
            //将postDTO添加到postDTOList中
            postDTOList.add(postDTO);
        }
        //设置pageDTO中postDTOList的值
        pageDTO.setPostDTOS(postDTOList);
        return pageDTO;
    }

    @Override
    public PageDTO findPostListByUserId(Integer userId, Integer page, Integer size) {
        PageDTO pageDTO = new PageDTO();
        //帖子的总条数
        PostExample postExample = new PostExample();
        postExample.createCriteria().andCreatorIdEqualTo(userId);
        Integer totalCount = (int) postMapper.countByExample(postExample);

        /**
         * 如果帖子总条数取余每页显示条数为0，则总页数为帖总条数除以每页显示数
         * 如果帖子总条数取余每页显示条数不为0，则总页数为帖总条数除以每页显示数再加一
         */
        Integer totalPage;

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        //防止传入数据库的page超过合理范围
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }

        pageDTO.setPage(totalPage, page);

        Integer offset = size * (page - 1);
        if (offset < 0) {
            offset = 0;
        }
        PostExample postExample1 = new PostExample();
        postExample1.createCriteria().andCreatorIdEqualTo(userId);
        List<Post> posts = postMapper.selectByExampleWithRowbounds(postExample1, new RowBounds(offset, size));

        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getCreatorId());
            PostDTO postDTO = new PostDTO();
            //通过spring内置的BeanUtils中的copyProperties方法将post的值覆盖postDTO
            BeanUtils.copyProperties(post, postDTO);
            //设置postDTO中user的值
            postDTO.setUser(user);
            //将postDTO添加到postDTOList中
            postDTOList.add(postDTO);
        }
        //设置pageDTO中postDTOList的值
        pageDTO.setPostDTOS(postDTOList);
        return pageDTO;
    }

    @Override
    public PostDTO findPostById(Integer id) {
        Post post = postMapper.selectByPrimaryKey(id);
        //判断传来的帖子id是否存在
        if (post == null) {
            throw new GeneralException(GeneralErrorCodeImpl.POST_NOT_FOUND);
        }
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        User user = userMapper.selectByPrimaryKey(post.getCreatorId());
        postDTO.setUser(user);
        return postDTO;
    }

    @Override
    public void createOrUpdatePost(Post post) {

        if (post.getId() == null) {
            post.setGmtCreate(System.currentTimeMillis());
            post.setGmtModified(post.getGmtCreate());
            postMapper.insert(post);
        } else {
            Post updatePost = new Post();

            updatePost.setTitle(post.getTitle());
            updatePost.setDescription(post.getDescription());
            updatePost.setTag(post.getTag());
            updatePost.setGmtModified(System.currentTimeMillis());

            PostExample postExample = new PostExample();

            postExample.createCriteria().andIdEqualTo(post.getId());
            int updateByExampleSelective = postMapper.updateByExampleSelective(updatePost, postExample);
            //判断帖子是否已经更新
            if (updateByExampleSelective != 1) {
                throw new GeneralException(GeneralErrorCodeImpl.POST_NOT_FOUND);
            }
        }
    }
}
