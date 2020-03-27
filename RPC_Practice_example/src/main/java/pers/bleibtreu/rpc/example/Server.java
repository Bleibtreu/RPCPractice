package pers.bleibtreu.rpc.example;

import pers.bleibtreu.rpc.server.RpcServer;
import pers.bleibtreu.rpc.server.RpcServerConfig;

/**
 * Created by Bleibtreu on 2020/3/20 17:50
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
