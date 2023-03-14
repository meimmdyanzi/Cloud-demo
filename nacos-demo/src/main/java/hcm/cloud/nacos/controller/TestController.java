package hcm.cloud.nacos.controller;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import hcm.cloud.common.vo.ResVO;
import hcm.cloud.common.vo.UserVO;
import hcm.cloud.nacos.service.IUserFeignService;
import hcm.cloud.nacos.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/17 22:52
 */
@Slf4j
@RefreshScope
@RestController
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IUserFeignService userFeignService;

    private Gson gson = new Gson();

    @RequestMapping("/getUser/{id}")
    public UserVO getUSer(@PathVariable("id") Integer id) {
        log.info("fegin client........");
        return userFeignService.getUser(id);
    }

    @RequestMapping("/addUserByForm")
    public ResVO addUserByForm() {
        UserVO userVO = UserVO.builder().userName("姓名测试").age(12).build();
        log.info("addUserByForm........");
        return userFeignService.addUserByForm(userVO);
    }

    @RequestMapping("/addUser")
    public UserVO addUser() {
        UserVO userVO = UserVO.builder().userName("姓名测试222").age(32).build();
        log.info("addUser........");
        return userFeignService.addUser(gson.toJson(userVO));
    }

    //    @RequestMapping("/user/{id}")
    //    public UserVO getUSer(@PathVariable("id") Integer id) {
    //        return restTemplate.getForObject("http://user-demo/user/" + id, UserVO.class);
    //    }

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

}
