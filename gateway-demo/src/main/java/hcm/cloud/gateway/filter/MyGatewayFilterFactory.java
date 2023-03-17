package hcm.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author huangchaoming
 * @reviewer liupeixu
 * @date 2023/3/17 16:28
 */
@Slf4j
@Component
public class MyGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(AbstractNameValueGatewayFilterFactory.NameValueConfig config) {
        return ((exchange, chain) -> {
            log.info("name:{},value:{}", config.getName(), config.getValue());
            ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> httpHeaders.add("token", UUID.randomUUID().toString())).build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }
    //
    //    public MyGatewayFilterFactory() {
    //        super(AbstractNameValueGatewayFilterFactory.NameValueConfig.class);
    //    }

}
