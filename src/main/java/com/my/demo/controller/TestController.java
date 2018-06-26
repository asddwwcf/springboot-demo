package com.my.demo.controller;

import com.my.demo.common.ResultBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试
     */
    @ApiOperation(value="测试hi", notes="测试22222")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @GetMapping("/hi")
    public ResultBean<String> hi() {
        return new ResultBean<String>("hi");
    }

}
