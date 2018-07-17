package com.example.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zcy on 2018/1/29.
 */
//@RestController
//public class LoginController {
//
//    @Reference(version = "1.0.0")
//    private UserLoginService loginService;
//
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public String login(String account, String password, HttpServletResponse response){
//        String token = null;
//        if(account != null && password != null){
//            TBUser tbUser =loginService.login(account,password);
//            tbUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
//            token=tbUser.getAccountName();
//        }
//        System.out.print(token);
//        return token;
//    }
//}
