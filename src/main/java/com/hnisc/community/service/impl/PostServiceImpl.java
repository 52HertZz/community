package com.hnisc.community.service.impl;

import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.mapper.PostMapper;
import com.hnisc.community.mapper.UserMapper;
import com.hnisc.community.model.Post;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
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
    public List<PostDTO> findPostList() {
        List<Post> posts = postMapper.findPostList();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : posts) {

            User user = userMapper.findByCreatorId(post.getCreatorId());
            PostDTO postDTO = new PostDTO();

            //通过spring内置的BeanUtils中的copyProperties方法将post的值覆盖postDTO
            BeanUtils.copyProperties(post,postDTO);
            //设置postDTO中user的值
            postDTO.setUser(user);
            //将postDTO添加到postDTOList中
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }

    @Override
    public void inertPost(Post post) {
        postMapper.inertPost(post);
    }
}
