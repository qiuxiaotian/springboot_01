package com.allsheng.springboot_01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
    @RequestMapping("/echo")
    public String echo(String msg) {
        LOGGER.info("接收msg的请求参数，内容为：{}", msg);
        return "[ECHO]" + msg;
    }
}
