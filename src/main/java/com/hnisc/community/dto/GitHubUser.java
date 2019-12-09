package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 */
@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private  String avatar_url;
}
