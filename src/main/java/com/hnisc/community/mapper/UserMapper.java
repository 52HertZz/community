package com.hnisc.community.mapper;

import com.hnisc.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lh141
 */
@Mapper
@Repository(value = "UserMapperImpl")
public interface UserMapper {

    //保存用户信息
    @Insert("insert into ic_user" +
            " (account_id,avatar_url,name,token,gmt_create,gmt_modified)" +
            " values" +
            " (#{accountId},#{avatarUrl},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void inertUser(User user);

    //通过token查询用户信息
    //不是类的情况下需要加@Param注解
    //@Param("token")
    @Select("select * from ic_user where token = #{token}")
    User findByToken(String token);

    //通过creatorId与ic_user表的id进行匹配，获取用户信息
    @Select("select * from ic_user where id = #{creatorId}")
    User findByCreatorId(Integer creatorId);
}
