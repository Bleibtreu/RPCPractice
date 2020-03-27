package pers.bleibtreu.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的序列化实现
 * Created by Bleibtreu on 2020/3/18 17:44
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
