package pers.bleibtreu.rpc.client;

import lombok.Data;
import pers.bleibtreu.rpc.HTTPTransportClient;
import pers.bleibtreu.rpc.Peer;
import pers.bleibtreu.rpc.TransportClient;
import pers.bleibtreu.rpc.codec.Decoder;
import pers.bleibtreu.rpc.codec.Encoder;
import pers.bleibtreu.rpc.codec.JSONDecoder;
import pers.bleibtreu.rpc.codec.JSONEncoder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bleibtreu on 2020/3/20 17:09
 */
@Data
public class RpcClientConfig {

    public RpcClientConfig() {

    }

    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> DecoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}
