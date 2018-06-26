package com.my.demo.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="测试hi", notes="测试22222")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

}
