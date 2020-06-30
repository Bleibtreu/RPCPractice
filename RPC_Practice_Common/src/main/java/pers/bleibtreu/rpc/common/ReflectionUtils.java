package pers.bleibtreu.rpc.common;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * <div>反射工具类</div>
 * Created by Bleibtreu on 2020/3/16 14:40
 */
public class ReflectionUtils {
    /**
     * 根据Class创建对象
     * @param clazz 待创建对象的类
     * @param <T> 对象类型
     * @return 创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个类的公共方法
     * @param clazz
     * @return
     */
    public static Method[] getPublicMethod(Class clazz) {
        //获取当前类的方法数组
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> methodList = new ArrayList<>();
        for (Method method : methods) {
            //过滤掉Private和protect方法
            if (Modifier.isPublic(method.getModifiers()))
                methodList.add(method);
        }
        return methodList.toArray(new Method[0]);
    }

    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}