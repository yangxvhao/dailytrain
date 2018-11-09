package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangxvhao
 * @date 2018-11-09 下午6:47.
 */
public class ThreadPoolTest {
    public static void run(ExecutorService service, int finalI){
        service.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + finalI);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();
        for (int i = 0; i < 20; i++) {
            try {
//                run(cachedThreadPool, i); 
//                run(fixedThreadPool, i); 
                run(singleThreadExecutor, i); 
//                if(i % 5 == 0)
//                    Thread.sleep(100);
            }catch (Exception e){
                
            }
        }

    }
}
