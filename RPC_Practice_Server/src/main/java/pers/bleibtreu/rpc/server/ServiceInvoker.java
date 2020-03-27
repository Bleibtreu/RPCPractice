package pers.bleibtreu.rpc.server;

import pers.bleibtreu.rpc.Request;
import pers.bleibtreu.rpc.common.ReflectionUtils;

/**
 * 调用服务
 * Created by Bleibtreu on 2020/3/20 15:47
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(
                service.getTargar(),
                service.getMethod(),
                request.getParameters()
        );
    }
}
