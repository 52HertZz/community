package com.hnisc.community.mapper;

import com.hnisc.community.model.Comment;
import org.springframework.stereotype.Repository;

/**
 * @author lh141
 */
@Repository("CommentMapperExample.xml")
public interface CommentMapperExample {

    void insert(Comment comment);
}
