package hcm.cloud.nacos.service;

import hcm.cloud.common.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/22 22:28
 */
@Service
public class TestService {
    @Value("${userName:abc}")
    private String userName;
    @Value("${age:10}")
    private int age;

//    @SentinelResource(value = "getUser", blockHandlerClass = ExceptionUtils.class, blockHandler = "blockException")
    public UserVO getUser() {
        return UserVO.builder().userName(userName).age(age).build();
    }

}
