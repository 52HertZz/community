package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 * GitHub用户信息
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;//描述
    private  String avatarUrl;
}
