package com.hnisc.community.interceptor;

import com.hnisc.community.model.User;
import com.hnisc.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lh141
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
