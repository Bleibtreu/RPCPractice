package pers.bleibtreu.rpc.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import pers.bleibtreu.rpc.Request;
import pers.bleibtreu.rpc.RequestHandler;
import pers.bleibtreu.rpc.Response;
import pers.bleibtreu.rpc.TransportServer;
import pers.bleibtreu.rpc.codec.Decoder;
import pers.bleibtreu.rpc.codec.Encoder;
import pers.bleibtreu.rpc.common.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Bleibtreu on 2020/3/20 15:51
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        // net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);

        // codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public  void start() {
        this.net.start();
    }

    public  void stop() {
        this.net.stop();
    }

    public RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream recive, OutputStream toResp) {
            Response resp = new Response();

            try {
                byte[] inBytes = IOUtils.readFully(recive, recive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request: {}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis,request);
                resp.setData(ret);

            } catch (IOException e) {
                log.warn(e.getMessage(), e);
                resp.setCode(1);
                resp.setMessage("RpcServer got error: " + e.getClass().getName() + " : " + e.getMessage());
            } finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
