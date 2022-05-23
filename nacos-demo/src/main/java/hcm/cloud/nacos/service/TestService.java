package hcm.cloud.nacos.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import hcm.cloud.nacos.vo.ResVO;
import hcm.cloud.nacos.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/22 22:28
 */
@Service
public class TestService {
    @Value("${userName}")
    private String userName;
    @Value("${age}")
    private int age;

    @SentinelResource(value = "getUser", blockHandler = "blockException")
    public UserVO getUser() {
        return UserVO.builder().userName(userName).age(age).build();
    }

    public ResVO blockException(BlockException e) {
        return ResVO.builder().resCode("1001").resMsg("被限流了").build();
    }
}
