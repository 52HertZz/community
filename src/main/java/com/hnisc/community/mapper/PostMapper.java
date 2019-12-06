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

}
