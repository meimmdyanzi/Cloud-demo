package hcm.cloud.nacos.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * @author huangchaoming
 * @reviewer liupeixu
 * @date 2023/2/26 16:10
 */

/**
 * 自定义拦截器实现认证
 */
public class FeignAuthRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("token", UUID.randomUUID().toString());
    }
}
