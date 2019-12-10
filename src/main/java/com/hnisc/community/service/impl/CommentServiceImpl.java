package com.hnisc.community.service.impl;

import com.hnisc.community.mapper.CommentMapper;
import com.hnisc.community.mapper.CommentMapperExample;
import com.hnisc.community.model.Comment;
import com.hnisc.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lh141
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapperExample commentMapperExample;

    @Override
    public void insert(Comment comment) {
        commentMapperExample.insert(comment);
    }
}
