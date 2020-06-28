package pers.bleibtreu.rpc.example;

/**
 * Created by Bleibtreu on 2020/3/20 17:52
 */
public class CalcServiceImpl implements CalcService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
