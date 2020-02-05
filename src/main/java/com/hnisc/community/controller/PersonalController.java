package com.hnisc.community.controller;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lh141
 * 个人中心
 */
@Controller
public class PersonalController {

    @Autowired
    private PostService postService;

    /**
     *  动态切换个人中心中的子页面
     */
    @GetMapping("/personal/{action}")
    public String personal(@PathVariable(name = "action") String action,
                           Model model,
                           HttpServletRequest request,
                           @RequestParam(name = "page", defaultValue = "1") Integer page,
                           @RequestParam(name = "size", defaultValue = "5") Integer size) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }

        if ("posts".equals(action)) {
            model.addAttribute("section", "posts");
            model.addAttribute("sectionName", "我的帖子");
        } else if ("reply".equals(action)) {
            model.addAttribute("section", "reply");
            model.addAttribute("sectionName", "最新回复");
        } else if ("collections".equals(action)) {
            model.addAttribute("section", "collections");
            model.addAttribute("sectionName", "我的收藏");
        } else if ("cancellation".equals(action)) {
            model.addAttribute("section", "cancellation");
            model.addAttribute("sectionName", "注销账号");
        }

        PageDTO pageDTO = postService.findPostListByUserId(user.getId(), page, size);
        model.addAttribute("pageDTO", pageDTO);
        return "personal";
    }
}
