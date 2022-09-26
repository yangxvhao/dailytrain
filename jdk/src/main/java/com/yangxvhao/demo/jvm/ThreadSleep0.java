package com.yangxvhao.demo.jvm;

import org.springframework.util.StopWatch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 主要涉及知识点：可数循环，不可数循环，安全点safePoint
 * @author yangxuhao on 2022-09-22.
 */
public class ThreadSleep0 {

  static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {

    Runnable runnable = () -> {
      for (int i = 0; i < 20000 * 10000; i++) {
        count.getAndIncrement();
        char[] chars = new char[1024];
        // 设置safePoint ,如果没有这段代码，主程序会阻塞等待t1,t2执行完成
//        if (i % 1000 == 0) {
//          try {
//            Thread.sleep(0);
//          } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//          }
//        }
      }
      System.out.println(Thread.currentThread().getName() + " end");
    };

    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);

    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    thread1.start();
    thread2.start();

    Thread.sleep(1000);
    stopWatch.stop();
    System.out.println((long) stopWatch.getTotalTimeSeconds() + "s");
    System.out.println("count=" + count.get());
  }

}
