package com.my.demo.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 登录相关dao
 */
public interface LoginDao {
    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    JSONObject getUser(@Param("username") String username, @Param("password") String password);
}
