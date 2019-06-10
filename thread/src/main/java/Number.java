import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxvhao
 * @date 2018-10-29 下午7:56.
 */
public class Number {
//    private static AtomicInteger count = new AtomicInteger(0);
    private static int count;
    
    public static void increase(){
//        count.incrementAndGet();
        count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        String phone = "15838125654";
        Long p = Long.parseLong(phone);
        System.out.println();
        
        Thread[] threads = new Thread[20];
        for (Thread thread : threads) {
            thread = new Thread(() -> {
                for(int i = 0; i < 10000; i ++){
                    increase();
                }
                
            });
//            thread.join();
//            thread.run();
            thread.start();
            System.out.println(thread.getName());
        }

//        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 1)
            Thread.yield();
        
        System.out.println(count);
    }
}
