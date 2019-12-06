package com.hnisc.community.controller;

import com.hnisc.community.dto.PageDTO;
import com.hnisc.community.model.User;
import com.hnisc.community.service.PostService;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /**
     *  "/"表示默认页面为index
     *  page表示当前页 ，默认当前页为1
     *  size表示每页显示的帖子条数，默认显示条数为7
     */
    @GetMapping("/")
    public  String index(HttpServletRequest request,
                         Model model,
                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                         @RequestParam(name = "size",defaultValue = "7") Integer size) {
        //通过request获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0){
            //for循环cookies，获取cookie的名称
            for (Cookie cookie : cookies) {
                //判断cookie是否和数据库中的token相等
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    //通过token获取user用户
                    User user = userService.findByToken(token);
                    /*
                    如果cookie和数据库中的token相等，
                    则表示数据库中存在该用户信息，用户直接登录
                    不相等则表示数据库中不存在用户，用户需要点击登录将数据存入数据库中
                     */
                    if (user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        PageDTO pageDTO = postService.findPostList(page,size);
        //使用model将数据传入页面
        model.addAttribute("pageDTO",pageDTO);
        return "index";
    }
}
