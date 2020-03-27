package pers.bleibtreu.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 表示一个具体服务
 * Created by Bleibtreu on 2020/3/20 14:43
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object targar;
    private Method method;
}
