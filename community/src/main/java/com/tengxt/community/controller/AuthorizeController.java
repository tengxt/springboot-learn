package com.tengxt.community.controller;

import com.tengxt.community.bean.User;
import com.tengxt.community.dto.AccessTokenDTO;
import com.tengxt.community.dto.GithubUserDTO;
import com.tengxt.community.provider.GithubProvider;
import com.tengxt.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.client.redirect.uri}")
    private String redirectUri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        // 获取accessToken
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        // 获取用户信息
        GithubUserDTO userDTO = githubProvider.getUser(accessToken);
        if(null != userDTO && null != userDTO.getId()){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(userDTO.getName());
            user.setAccountId(String.valueOf(userDTO.getId()));
            user.setAvatarUrl(userDTO.getAvatarUrl());
            boolean orUpdate = userService.createOrUpdate(user);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            return "redirect:/";
        }else{
            // 登录失败，返回主页
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        // 清空session
        request.getSession().removeAttribute("user");
        // 清空cookie
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
