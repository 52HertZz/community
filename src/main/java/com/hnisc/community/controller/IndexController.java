package com.hnisc.community.controller;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lh141
 * 首页
 */
@Controller
public class IndexController {

    @Autowired
    private PostService postService;

    /**
     * "/"表示默认页面为index
     * page表示当前页 ，默认当前页为1
     * size表示每页显示的帖子条数，默认显示条数为5
     */
    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PageDTO pageDTO = postService.findPostList(page, size);
        //使用model将数据传入页面
        model.addAttribute("pageDTO", pageDTO);
        return "index";
    }
}
