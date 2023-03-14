package hcm.cloud.nacos.config;

import feign.Logger;
import feign.Request;
import hcm.cloud.nacos.interceptor.FeignAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author huangchaoming
 * @reviewer liupeixu
 * @date 2023/2/26 16:01
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feginLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 自定义拦截器实现认证
     */
    @Bean
    public FeignAuthRequestInterceptor feignAuthRequestInterceptor() {
        return new FeignAuthRequestInterceptor();
    }

    /**
     * 超时配置
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(3, TimeUnit.SECONDS, 10, TimeUnit.SECONDS, true);
    }
}
