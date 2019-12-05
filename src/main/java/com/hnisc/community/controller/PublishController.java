package com.hnisc.community.controller;

import com.hnisc.community.model.Post;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author lh141
 */
@Controller
public class PublishController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    /*
    GetMapping负责页面跳转
    PostMapping负责数据传输
     */

    @GetMapping("/publish")
    public String publish(){
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
            HttpServletRequest request,
            Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if(title == null || title == ""){
            model.addAttribute("error","标题不能为空，请输入帖子标题......");
            return "publish";
        }
        if(description == null || description == ""){
            model.addAttribute("error","内容不能为空，请输入帖子内容......");
            return "publish";
        }
        if(tag == null || tag == ""){
            model.addAttribute("error","标签不能为空，请输入帖子标签......");
            return "publish";
        }

        //通过cookie获取发帖用户的信息
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    user = userService.findByToken(token);
                    if (user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        Post post = new Post();
        post.setTitle(title);
        post.setDescription(description);
        post.setTag(tag);
        post.setCreatorId(user.getId());
        post.setGmtCreate(System.currentTimeMillis());
        post.setGmtModified(post.getGmtModified());

        postService.inertPost(post);
        //发布成功，返回index页面
        return "redirect:/";
    }
}
