package com.hnisc.community.model;

import lombok.Data;

/**
 * @author lh141
 * 用户
 */
@Data
public class User {
    private Integer id;//用户id
    private String avatarUrl;//用户头像地址
    private String accountId;//平台id
    private String name;//用户名
    private String token;//用户登录令牌
    private Long gmtCreate;//创建时间
    private Long gmtModified;//修改时间
}
