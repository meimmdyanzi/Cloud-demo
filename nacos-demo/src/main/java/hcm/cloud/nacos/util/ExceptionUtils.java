package hcm.cloud.nacos.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import hcm.cloud.common.vo.ResVO;

/**
 * @author huangchaoming
 * @reviewer zhenshiyu
 * @date 2022/5/23 21:15
 */
public class ExceptionUtils {
    public static ResVO blockException(BlockException e) {
        return ResVO.builder().resCode("1001").resMsg("被限流了").build();
    }

    public static ResVO fallBack(Throwable e) {
        return ResVO.builder().resCode("1002").resMsg("降级了").build();
    }
}
