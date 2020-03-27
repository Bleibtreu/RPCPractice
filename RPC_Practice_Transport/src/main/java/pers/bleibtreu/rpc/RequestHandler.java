package pers.bleibtreu.rpc;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 * Created by Bleibtreu on 2020/3/20 13:26
 */
public interface RequestHandler {
    void onRequest(InputStream recive, OutputStream toResp);
}
