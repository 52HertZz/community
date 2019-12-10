package com.hnisc.community.dto;

import com.hnisc.community.model.User;
import lombok.Data;

/**
 * @author lh141
 * 帖子
 */
@Data
public class PostDTO {
    private Long id;//帖子id
    private String title;//帖子标题
    private String description;//帖子描述
    private String tag;//帖子标签
    private Long gmtCreate;//帖子创建时间
    private Long gmtModified;//帖子修改时间
    private Integer creatorId;//发帖人id
    private Integer likeCount;//点赞数
    private Integer dislikeCount;//点踩数
    private Integer commentCount;//评论数
    private Integer favoriteCount;//收藏数
    private Integer viewCount;//浏览数
    private User user;//用户信息
}
