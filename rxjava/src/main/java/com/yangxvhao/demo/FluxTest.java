package com.yangxvhao.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * @author yangxuhao
 * @date 2018-11-26 16:34.
 */
public class FluxTest {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(FluxTest.class);
//        try {
//            Thread thread = new Thread(() ->
//                    Flux.interval(Duration.ofMillis(1000), Duration.ofMillis(2000)).subscribe(aLong -> System.out.println(aLong))
//            );
//
//            thread.start();
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(300000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Flux.interval(Duration.ofMillis(1000), Duration.ofMillis(2000)).subscribeOn(Schedulers.immediate()).timeout(Duration.ofMillis(20000)).log().subscribe(System.out::println);
//        Flux.interval(Duration.ofMillis(1000)).subscribe(aLong -> System.out.println("1"));
//        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

    }
}
