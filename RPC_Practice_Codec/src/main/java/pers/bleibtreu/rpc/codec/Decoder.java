package pers.bleibtreu.rpc.codec;

/**
 * 反序列化类
 * Created by Bleibtreu on 2020/3/18 17:39
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
