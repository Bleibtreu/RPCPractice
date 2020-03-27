package pers.bleibtreu.rpc;

import java.io.InputStream;

/**
 * 创建连接
 * 发送数据，并且等待响应
 * 关闭连接
 * Created by Bleibtreu on 2020/3/20 13:21
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
