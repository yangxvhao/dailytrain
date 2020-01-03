package com.yangxvhao.demo;

import com.yangxvhao.demo.service.HelloWorldService;
import com.yangxvhao.demo.service.impl.HelloWorldServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            TServerTransport tServerTransport = new TServerSocket(9090);
            HelloWorldService.Processor<HelloWorldService.Iface> processor =
                    new HelloWorldService.Processor<>(new HelloWorldServiceImpl());

            TServer.Args args1 = new TSimpleServer.Args(tServerTransport);
            args1.processor(processor);
            args1.protocolFactory(new TBinaryProtocol.Factory());

            TServer tServer = new TSimpleServer(args1);
            System.out.println("-----server is start------");
            tServer.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
