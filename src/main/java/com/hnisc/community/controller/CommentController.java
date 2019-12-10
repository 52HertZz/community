//package com.hnisc.community.controller;
//
//import com.hnisc.community.dto.CommentDTO;
//import com.hnisc.community.model.Comment;
//import com.hnisc.community.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * @author lh141
// */
//@Controller
//public class CommentController {
//
//    @Autowired
//    private CommentService commentService;
//
//    @ResponseBody
//    @RequestMapping(value = "/comment", method = RequestMethod.POST)
//    public Object comment(@RequestBody CommentDTO commentDTO) {
//        Comment comment = new Comment();
//
//        comment.setParentId(commentDTO.getParentId());
//        comment.setParentType(1);
//        comment.setCommentatorId(13L);
//        comment.setDescription(commentDTO.getDescription());
//        comment.setGmtCreate(System.currentTimeMillis());
//        comment.setGmtModified(System.currentTimeMillis());
//
//        commentService.insert(comment);
//        return null;
//    }
//}
