package pers.bleibtreu.rpc.server;

import lombok.Data;
import pers.bleibtreu.rpc.HTTPTransportServer;
import pers.bleibtreu.rpc.TransportServer;
import pers.bleibtreu.rpc.codec.Decoder;
import pers.bleibtreu.rpc.codec.Encoder;
import pers.bleibtreu.rpc.codec.JSONDecoder;
import pers.bleibtreu.rpc.codec.JSONEncoder;

/**
 * server配置
 * Created by Bleibtreu on 2020/3/20 14:33
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> DecoderClass = JSONDecoder.class;
    private int port = 3000;
}
