package com.hnisc.community.controller;

import com.hnisc.community.dto.PostDTO;
import com.hnisc.community.model.Post;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lh141
 * 发布
 */
@Controller
public class PublishController {

    @Autowired
    private PostService postService;

    /*
    GetMapping负责页面跳转
    PostMapping负责数据传输
     */
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    /*
    编辑修改页面
     */
    @GetMapping("/publish/{id}")
    public String update(@PathVariable(name = "id") Long id,
                         Model model) {
        PostDTO postDTO = postService.findPostById(id);

        model.addAttribute("title", postDTO.getTitle());
        model.addAttribute("description", postDTO.getDescription());
        model.addAttribute("tag", postDTO.getTag());
        model.addAttribute("id",postDTO.getId());
        return "publish";
    }

    /*
    用户发帖：
        包括帖子标题，内容，标签，发帖人id，创建时间和修改时间
     */
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam("id") Long id,
            HttpServletRequest request,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空，请输入帖子标题......");
            return "publish";
        }
        if (description == null || description == "") {
            model.addAttribute("error", "内容不能为空，请输入帖子内容......");
            return "publish";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空，请输入帖子标签......");
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setDescription(description);
        post.setTag(tag);
        post.setCreatorId(user.getId());

        postService.createOrUpdatePost(post);
        //发布成功，返回index页面
        return "redirect:/";
    }
}
