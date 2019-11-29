package lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangxuhao
 * @date 2019-11-29 16:36.
 */
public class LockTest {
    @Test
    public void testSleepAndWait(){
        Integer integer = 0;
        ReentrantLock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " is running!!!");
            try {
                System.out.println("释放锁");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "is running----");
        }).start();
    }
}
