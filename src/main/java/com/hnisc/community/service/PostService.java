package com.hnisc.community.service;

import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.model.Post;

import java.util.List;

/**
 * @author lh141
 */
public interface PostService {

    List<PostDTO> findPostList();

    void inertPost(Post post);
}
