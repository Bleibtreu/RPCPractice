package pers.bleibtreu.rpc.client;

import pers.bleibtreu.rpc.Peer;
import pers.bleibtreu.rpc.TransportClient;

import java.util.List;

/**
 * 表示选择哪个server去连接
 * Created by Bleibtreu on 2020/3/20 16:25
 */
public interface TransportSelector {
    /**
     * 初始化select
     * @param peers 可以连接的server端点信息
     * @param count client于server建立多少个连接
     * @param clazz client实现class
     */
    void init(List<Peer> peers, int count, Class<? extends  TransportClient> clazz);

    /**
     * 选择一个transport与server做交互
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);

    void close();
}
