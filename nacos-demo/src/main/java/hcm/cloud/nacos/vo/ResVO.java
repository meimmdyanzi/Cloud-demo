package hcm.cloud.nacos.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @Description 描述类
 * @Author huangchaoming
 * @CreateTime 2022/5/22 22:31
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResVO {
    String resCode;
    String resMsg;
}
