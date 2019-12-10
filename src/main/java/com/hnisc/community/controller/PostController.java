package com.hnisc.community.controller;

import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lh141
 * 帖子
 */
@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Long id,
                       Model model) {
        PostDTO postDTO = postService.findPostById(id);
        //实现浏览数的累加
        postService.incViewCount(id);

        model.addAttribute("postDTO", postDTO);
        return "post";
    }
}
