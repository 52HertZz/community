package com.hnisc.community.service;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.model.Post;

import java.util.List;

/**
 * @author lh141
 */
public interface PostService {

    PageDTO findPostList(Integer page, Integer size);

    void inertPost(Post post);

    PageDTO findPostListByUserId(Integer userId, Integer page, Integer size);

    PostDTO findPostById(Integer id);
}
