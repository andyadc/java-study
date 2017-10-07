package com.andyadc.thrift.client;

import com.andyadc.thrift.service.HelloService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @author andy.an
 * @since 2017/10/7
 */
public class ThriftClient {

    public static void main(String[] args) throws Exception {
        TTransport transport;
        transport = new TSocket("localhost", 9999);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        HelloService.Client client = new HelloService.Client(protocol);

        System.out.println(client.ping());

        transport.close();
    }
}
