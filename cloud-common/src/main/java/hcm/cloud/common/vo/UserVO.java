package hcm.cloud.common.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/21 17:03
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserVO extends ResVO {
    String userName;
    Integer age;
    Integer id;
}
