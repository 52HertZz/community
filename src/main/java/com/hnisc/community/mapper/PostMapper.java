package com.hnisc.community.mapper;

import com.hnisc.community.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lh141
 */
@Mapper
@Repository(value = "PostMapperImpl")
public interface PostMapper {

    //通过帖子id查询帖子内容
    @Select("select * from ic_post where id = #{id}")
    Post findPostById(Integer id) ;

    //保存帖子信息
    @Insert("insert into ic_post" +
            " (title,description,tag,gmt_create,gmt_modified,creator_id)" +
            " values" +
            " (#{title},#{description},#{tag},#{gmtCreate},#{gmtModified},#{creatorId})")
    void inertPost(Post post);

    //分页查询帖子内容
    @Select("select * from ic_post limit #{offset},#{size}")
    List<Post> findPostList(Integer offset, Integer size);

    //查询帖子总数
    @Select("select count(1) from ic_post")
    Integer count();

    //通过发帖人id与用户id比较，分页查询帖子内容
    @Select("select * from ic_post where creator_id = #{userId} limit #{offset},#{size}")
    List<Post> findPostListByUserId(Integer userId, Integer offset, Integer size);

    @Select("select count(1) from ic_post where creator_id = #{userId}")
    Integer countByUserId(Integer userId);
}
