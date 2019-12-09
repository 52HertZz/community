package com.hnisc.community.mapper;

import com.hnisc.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    //更新用户信息
    @Update("update ic_user" +
            " set" +
            " gmt_modified = #{gmtModified},avatar_url = #{avatarUrl},name = #{name},token = #{token}" +
            " where id = #{id}")
    void updateUser(User dbUser);

    //通过token查询用户信息
    @Select("select * from ic_user where token = #{token}")
    User findByToken(String token);

    //通过creatorId与ic_user表的id进行匹配，获取用户信息
    @Select("select * from ic_user where id = #{creatorId}")
    User findByCreatorId(Integer creatorId);

    //通过github的account_id与数据库中的account_id，判断数据库中是否存在该用户
    @Select("select * from ic_user where account_id = #{accountId}")
    User findByAccountId(String accountId);

}
