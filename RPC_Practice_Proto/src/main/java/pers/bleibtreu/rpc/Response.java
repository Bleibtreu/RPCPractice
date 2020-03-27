package pers.bleibtreu.rpc;

import lombok.Data;

/**
 * 表示RPC的返回
 * Created by Bleibtreu on 2020/3/16 14:34
 */
@Data
public class Response {

    // 服务返回编码，0-成功。非0失败
    private int code = 0;
    // 具体的错误信息
    private String message = "ok";
    // 返回的数据
    private Object data;

}
