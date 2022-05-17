package hcm.cloud.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/17 22:52
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
