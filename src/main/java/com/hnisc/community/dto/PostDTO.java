package com.hnisc.community.dto;

import com.hnisc.community.model.User;
import lombok.Data;

/**
 * @author lh141
 * 帖子
 */
@Data
public class PostDTO {
    //帖子id
    private Long id;
    //帖子标题
    private String title;
    //帖子描述
    private String description;
    //帖子标签
    private String tag;
    //帖子创建时间
    private Long gmtCreate;
    //帖子修改时间
    private Long gmtModified;
    //发帖人id
    private Integer creatorId;
    //点赞数
    private Integer likeCount;
    //点踩数
    private Integer dislikeCount;
    //评论数
    private Integer commentCount;
    //收藏数
    private Integer favoriteCount;
    //浏览数
    private Integer viewCount;
    //用户信息
    private User user;
}
