package com.example.demo;

import com.example.demo.annotation.MyScan;
import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceB;
import com.example.demo.util.ThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static jodd.util.ThreadUtil.sleep;

@Slf4j
@RunWith(SpringRunner.class)
@MyScan
@SpringBootTest()
public class DemoApplicationTests {
    @Autowired
    ServiceA serviceA;

    @SpyBean
    ServiceB serviceB;

    /**
     * 发送消息同步等待接收消息
     * 并不能发挥出消费者数量的优势，发送消息的线程必须等待接收到消息后才能重新发起请求
     * @throws InterruptedException
     */
    @Test
    public void syncReceiveMessage() throws InterruptedException {
        int sum = 200;
        ThreadPool pool = new ThreadPool(30);
        for (int i = 0; i < sum; i++) {
            ThreadPool.PostRequestTask postRequestTask = pool.create("http://127.0.0.1:8999/rabbit/send", i + "");
            pool.execute(postRequestTask);
        }
        pool.shutdown();
        pool.await();
        log.info("sum:{},success:{}", sum, pool.getSuccessCount());
    }

    @Test
    public void testServiceA(){
        Mockito.doNothing().when(serviceB).diplay();
        serviceA.methodA();
    }
}
