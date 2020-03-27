package pers.bleibtreu.rpc.server;

import org.junit.Before;
import org.junit.Test;
import pers.bleibtreu.rpc.Request;
import pers.bleibtreu.rpc.ServiceDescriptor;
import pers.bleibtreu.rpc.common.ReflectionUtils;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethod(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}