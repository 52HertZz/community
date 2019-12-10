package com.hnisc.community.dto;

import lombok.Data;

/**
 * @author lh141
 * 回复
 */
@Data
public class CommentDTO {
    private Long parentId;//父类id
    private String description;//回复描述
    private Integer parentType;//父类类型
}
