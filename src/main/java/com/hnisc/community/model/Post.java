package com.hnisc.community.model;

public class Post {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.title
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.tag
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.gmt_create
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.gmt_modified
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.creator_id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer creatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.like_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.dislike_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer dislikeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.comment_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.favorite_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer favoriteCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.view_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ic_post.description
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.id
     *
     * @return the value of ic_post.id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.id
     *
     * @param id the value for ic_post.id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.title
     *
     * @return the value of ic_post.title
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.title
     *
     * @param title the value for ic_post.title
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.tag
     *
     * @return the value of ic_post.tag
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.tag
     *
     * @param tag the value for ic_post.tag
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.gmt_create
     *
     * @return the value of ic_post.gmt_create
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.gmt_create
     *
     * @param gmtCreate the value for ic_post.gmt_create
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.gmt_modified
     *
     * @return the value of ic_post.gmt_modified
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.gmt_modified
     *
     * @param gmtModified the value for ic_post.gmt_modified
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.creator_id
     *
     * @return the value of ic_post.creator_id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.creator_id
     *
     * @param creatorId the value for ic_post.creator_id
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.like_count
     *
     * @return the value of ic_post.like_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.like_count
     *
     * @param likeCount the value for ic_post.like_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.dislike_count
     *
     * @return the value of ic_post.dislike_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getDislikeCount() {
        return dislikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.dislike_count
     *
     * @param dislikeCount the value for ic_post.dislike_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.comment_count
     *
     * @return the value of ic_post.comment_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.comment_count
     *
     * @param commentCount the value for ic_post.comment_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.favorite_count
     *
     * @return the value of ic_post.favorite_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.favorite_count
     *
     * @param favoriteCount the value for ic_post.favorite_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.view_count
     *
     * @return the value of ic_post.view_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.view_count
     *
     * @param viewCount the value for ic_post.view_count
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ic_post.description
     *
     * @return the value of ic_post.description
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ic_post.description
     *
     * @param description the value for ic_post.description
     *
     * @mbg.generated Mon Dec 09 18:02:15 GMT+08:00 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}