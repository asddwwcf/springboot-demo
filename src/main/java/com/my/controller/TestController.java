package com.my.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: TestController
 * Description:
 * Created by gzq on 2018/6/25 0025.
 */
@RestController
public class TestController {

    /**
     * 测试
     */
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

}
