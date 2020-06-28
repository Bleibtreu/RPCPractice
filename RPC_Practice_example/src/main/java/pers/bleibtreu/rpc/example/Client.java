package pers.bleibtreu.rpc.example;

import pers.bleibtreu.rpc.client.RpcClient;
import pers.bleibtreu.rpc.client.RpcClientConfig;

/**
 * Created by Bleibtreu on 2020/3/20 17:50
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int r1 = service.add(1, 2);
        int r2 = service.minus(10, 8);

        System.out.println(r1);
        System.out.println(r2);
    }
}
