package pers.bleibtreu.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <div>表示RPC的一个请求</div>
 * Created by Bleibtreu on 2020/3/16 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private ServiceDescriptor service;
    private Object[] parameters;

}
