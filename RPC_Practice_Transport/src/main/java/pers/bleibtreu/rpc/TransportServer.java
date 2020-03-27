package pers.bleibtreu.rpc;

/**
 * 启动，监听端口
 * 接受请求
 * 关闭监听
 * Created by Bleibtreu on 2020/3/20 13:24
 */
public interface TransportServer {
    void init(int port, RequestHandler handle);

    void start();

    void stop();
}
