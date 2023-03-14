package hcm.cloud.common.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/22 22:31
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResVO {
    String resCode;
    String resMsg;
    Integer port;
}
