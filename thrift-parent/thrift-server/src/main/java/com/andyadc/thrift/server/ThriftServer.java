package com.andyadc.thrift.server;

import com.andyadc.thrift.service.HelloService;
import com.andyadc.thrift.service.HelloServiceImpl;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * @author andy.an
 * @since 2017/10/7
 */
public class ThriftServer {

    public static HelloService.Iface service;
    public static HelloService.Processor processor;

    public static void main(String[] args) throws Exception {

        service = new HelloServiceImpl();
        processor = new HelloService.Processor(service);

        new Thread(new Runnable() {
            @Override
            public void run() {
                server(processor);
            }
        }).start();
    }

    public static void server(HelloService.Processor processor) {
        try {
            TServerTransport transport = new TServerSocket(9999);
            TServer server = new TSimpleServer(new TServer.Args(transport).processor(processor));
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
