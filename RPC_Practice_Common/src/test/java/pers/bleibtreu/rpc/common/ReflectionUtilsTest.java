package pers.bleibtreu.rpc.common;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void getPublicMethod() {
        Method[] methods = ReflectionUtils.getPublicMethod(TestClass.class);
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethod(TestClass.class);
        Method a = methods[0];
        TestClass t = new TestClass();
        Object obj = ReflectionUtils.invoke(t, a);
        assertEquals("a", obj);
    }
}