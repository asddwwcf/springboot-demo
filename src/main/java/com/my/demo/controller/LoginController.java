package com.my.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.my.demo.service.LoginService;
import com.my.demo.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 登录相关Controller
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param requestJson
     * @return
     */
    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "username,password");
        return loginService.authLogin(requestJson);
    }

    /**
     * 查询当前登录用户的信息
     *
     * @return
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     *
     * @return
     */
    @PostMapping("/logout")
    public JSONObject logout() {
        return loginService.logout();
    }
}
