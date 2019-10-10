package com.hzs.bootlaunch.controller;

import com.hzs.bootlaunch.dto.AccessTokenDTO;
import com.hzs.bootlaunch.dto.GithubUser;
import com.hzs.bootlaunch.mapper.UserMapper;
import com.hzs.bootlaunch.model.User;
import com.hzs.bootlaunch.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.Redirect_uri}")
    private String Redirect_uri;
    @Value("${github.Client_id}")
    private String Client_id;
    @Value("${github.Client_secret}")
    private String Client_secret;
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(Redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(Client_id);
        accessTokenDTO.setClient_secret(Client_secret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            //登录成功,存入session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else{
            //登录失败,重新登录
            return "redirect:/";
        }

    }
}
