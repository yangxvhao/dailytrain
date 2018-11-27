package com.yangxvhao.demo;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author yangxuhao
 * @date 2018-11-26 16:34.
 */
public class FluxTest {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(() ->
                    Flux.interval(Duration.ofMillis(1000), Duration.ofMillis(2000)).subscribe(aLong -> System.out.println(aLong))
            );

            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Flux.interval(Duration.ofMillis(1000)).subscribe(aLong -> System.out.println("1"));
//        Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);

    }
}
