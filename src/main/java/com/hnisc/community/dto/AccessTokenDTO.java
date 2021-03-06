package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 * 访问令牌
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}