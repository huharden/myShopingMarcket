package com.hqjy.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    private int port;
    @RequestMapping("index")
    public String index() {
        return "HelloWorld:"+port;
    }
}
