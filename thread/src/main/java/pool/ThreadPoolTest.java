package pool;

import org.springframework.util.StopWatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxvhao
 * @date 2018-11-09 下午6:47.
 */
public class ThreadPoolTest {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void run(ExecutorService service, int finalI, CountDownLatch latch){
        service.execute(() -> {
            latch.countDown();
            count.incrementAndGet();
            System.out.println(Thread.currentThread().getName() + ":" + finalI + ", count:" + count.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void main(String[] args) throws InterruptedException {
         Thread.sleep(20000);
        int len = 500;
        CountDownLatch latch = new CountDownLatch(len);
        ThreadPoolExecutor myPool = new ThreadPoolExecutor(10, 15, 10000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5), new MyThreadFactory("myThread-"), new MyRejectedHandler());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
//        Executors.newWorkStealingPool();

        for (int i = 0; i < len; i++) {
            try {
                int finalI = i;
                myPool.execute(() -> {
                    latch.countDown();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + finalI);
                });
//                run(cachedThreadPool, i); 
//                run(fixedThreadPool, i, latch);
//                run(singleThreadExecutor, i);
//                if(i % 5 == 0)
//                    Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            latch.await(len * 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(latch.getCount() == 0) {
            System.out.println("task is end : " + count.get());
        }
//        myPool.shutdown();

    }
}
