package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 */
@Data
public class AccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;
}