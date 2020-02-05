package com.hnisc.community.controller;

import com.hnisc.community.dto.AccessTokenDTO;
import com.hnisc.community.dto.GitHubUser;
import com.hnisc.community.model.User;
import com.hnisc.community.provider.GitHubProvider;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lh141
 * GitHub授权
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GitHubProvider gitHubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    /**
     * @param code
     * @param state
     * @param response
     * @return
     * @throws IOException 回调
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();

        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);

        String accessToken = gitHubProvider.getAccessToken(accessTokenDTO);
        GitHubUser gitHubUser = gitHubProvider.getUser(accessToken);
        if (gitHubUser != null && gitHubUser.getId() != null) {
            //将用户信息存入数据库
            User user = new User();

            String token = UUID.randomUUID().toString();

            user.setAccountId(String.valueOf(gitHubUser.getId()));
            user.setAvatarUrl(gitHubUser.getAvatarUrl());
            user.setName(gitHubUser.getName());
            user.setToken(token);

            //登录成功,写cookie和session
            //使用数据库存储代替session
            userService.createOrUpdateUser(user);
            //将token存入cookie
            response.addCookie(new Cookie("token", token));

            //返回index页面
            return "redirect:/";
        } else {
            //登录失败，重新登录
            //返回index页面
            return "redirect:/";
        }
    }

    /**
     *  用户退出登录
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        //清楚浏览器中的session和token
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
