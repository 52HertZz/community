package com.hnisc.community.service;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.model.Post;

/**
 * @author lh141
 */
public interface PostService {

    PageDTO findPostList(Integer page, Integer size);

    PageDTO findPostListByUserId(Long userId, Integer page, Integer size);

    PostDTO findPostById(Long id);

    void createOrUpdatePost(Post post);

    void incViewCount(Long id);
}
