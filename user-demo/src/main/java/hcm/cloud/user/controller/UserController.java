package hcm.cloud.user.controller;

import com.alibaba.nacos.shaded.com.google.gson.Gson;
import hcm.cloud.common.vo.ResVO;
import hcm.cloud.common.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangchaoming
 * @reviewer liupeixu
 * @date 2023/2/26 14:39
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${server.port}")
    private int port;

    private Gson gson = new Gson();

    @RequestMapping("/getUser/{id}")
    public UserVO getUSer(@PathVariable("id") Integer id, @RequestHeader("X-Request-name") String name) {
        log.info("getUser id:{},name:{}", id, name);
        return UserVO.builder().userName("用户名" + name).age(id).id(id).port(port).build();
    }

    @PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO addUser(@RequestBody String data) {
        log.info("data:{}", data);
        UserVO userVO = gson.fromJson(data, UserVO.class);
        userVO.setUserName("名字给user改了");
        return userVO;
    }

    @PostMapping(value = "/addUserByForm", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResVO addUserByForm(UserVO userVO) {
        log.info("userVO:{}", userVO);
        return ResVO.builder().port(port).resCode("0").resMsg("OK").build();
    }
}
