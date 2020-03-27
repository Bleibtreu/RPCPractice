package pers.bleibtreu.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的反序列化类
 * Created by Bleibtreu on 2020/3/18 17:53
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
