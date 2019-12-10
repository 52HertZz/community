package com.hnisc.community.exception.handler;

import com.hnisc.community.exception.GeneralException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lh141
 * 通用异常处理程序
 */
@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handler(Throwable throwable, Model model) {
        if (throwable instanceof GeneralException) {
            model.addAttribute("message", throwable.getMessage());
        } else {
            model.addAttribute("message", " 服务器冒烟啦~~请稍后再试~~");
        }
        return new ModelAndView("error");
    }
}
