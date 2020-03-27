package pers.bleibtreu.rpc.codec;

/**
 * 序列化类
 * Created by Bleibtreu on 2020/3/18 17:38
 */
public interface Encoder {
    byte[] encode(Object obj);
}
