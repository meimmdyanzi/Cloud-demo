package hcm.cloud.nacos.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/21 17:03
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVO {
    String userName;
    int age;
}
