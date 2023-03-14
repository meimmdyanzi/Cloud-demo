package hcm.cloud.nacos.service;

import hcm.cloud.common.vo.ResVO;
import hcm.cloud.common.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangchaoming
 * @reviewer liupeixu
 * @date 2023/2/26 15:33
 */
@FeignClient(value = "user-demo")
public interface IUserFeignService {
    @RequestMapping("/getUser/{id}")
    public UserVO getUser(@PathVariable("id") Integer id);

    @PostMapping(value = "/addUserByForm",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResVO addUserByForm(UserVO userVO);

    @PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO addUser(String data);
}
