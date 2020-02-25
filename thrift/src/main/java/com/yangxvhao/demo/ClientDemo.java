package com.yangxvhao.demo;

import com.yangxvhao.demo.request.HelloWorldRequest;
import com.yangxvhao.demo.service.HelloWorldService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ClientDemo {
    public static void main(String[] args) {
        TTransport tTransport = new TSocket("127.0.0.1", 9090);
        TProtocol tProtocol = new TBinaryProtocol(tTransport);
        HelloWorldService.Client client = new HelloWorldService.Client(tProtocol);
        try {
            tTransport.open();
            client.hello("hello world");
            HelloWorldRequest request = new HelloWorldRequest();
//            request.setAge(10);
            request.setNameIsSet(false);
            request.setName("name");
            System.out.println(client.modify(request));
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
