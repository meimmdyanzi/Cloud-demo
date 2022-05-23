package hcm.cloud.nacos.controller;

import hcm.cloud.nacos.service.TestService;
import hcm.cloud.nacos.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/17 22:52
 */
@RefreshScope
@RestController
public class TestController {
    @Autowired
    private TestService testService;


    @GetMapping("/user")
    public UserVO user() {
        return testService.getUser();
    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }
}
