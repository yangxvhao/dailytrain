import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangxvhao
 * @date 18-5-2.
 */
public class Main {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        
        reentrantLock.lock();
        long start = 0;
        if(count.compareAndSet(1, 0)){
            try {
                start = System.currentTimeMillis();
                System.out.println("await:100");
                condition.await(10000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
//                reentrantLock.unlock();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        new Thread(() -> {
            try {
                count.set(2);

                condition.signalAll();
            }catch (IllegalMonitorStateException e)
            {
                
            }
        }).run();
        
    }
}
