package com.hnisc.community.mapper;

import com.hnisc.community.model.Post;
import org.springframework.stereotype.Repository;

/**
 * @author lh141
 */
@Repository("PostMapperExample.xml")
public interface PostMapperExample {

    int incViewCount(Post post);

    void insert(Post post);
}
