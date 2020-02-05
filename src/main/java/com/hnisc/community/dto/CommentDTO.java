package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 * 回复
 */
@Data
public class CommentDTO {
    //父类id
    private Long parentId;
    //回复描述
    private String description;
    //父类类型
    private Integer parentType;
}
