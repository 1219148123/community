package com.hzs.bootlaunch.controller;


import com.hzs.bootlaunch.mapper.QuestionMapper;
import com.hzs.bootlaunch.mapper.UserMapper;
import com.hzs.bootlaunch.model.Question;
import com.hzs.bootlaunch.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @GetMapping("/")
    public String greeting(HttpServletRequest request,
                           Model model) {
        Cookie[] cookies = request.getCookies();
        User user = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<Question> questions = questionMapper.allQuestion();
        for (Question question : questions) {
            System.out.println(question);
        }
        model.addAttribute("questions",questions);
        return "index";
    }

}