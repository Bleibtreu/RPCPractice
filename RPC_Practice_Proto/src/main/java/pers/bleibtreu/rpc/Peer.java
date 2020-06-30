package pers.bleibtreu.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <div>示网络传输的一个端点</div>表
 * Created by Bleibtreu on 2020/3/16 14:27
 */
@Data
@AllArgsConstructor
public class Peer {

    private String host;
    private int port;

}
