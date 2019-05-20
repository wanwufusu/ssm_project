package com.ssm.controller;

import com.ssm.bean.User;
import com.ssm.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(){
        return "login";
    }

   @RequestMapping("/ajaxLogin" )
   @ResponseBody
    public Object login(HttpSession session,String username, String password){
       Map<String,Object> map = new HashMap<>();
        User user;
            if (userService.findUserByUsername(username) != null) {
                user = userService.findUserByPassword(username, password);
                if (user != null) {
                    user.setRolename("超级管理员");
                    session.setAttribute("activeUser", user);
                    map.put("msg", "OK");
                    return map;
                } else {
                    map.put("msg", "password_error");
                    return map;
                }
            }
            map.put("msg", "account_error");

            return map;
        }

}
