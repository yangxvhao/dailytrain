package pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxuhao
 * @date 2019-06-10 16:45.
 */
public class MyThreadFactory implements ThreadFactory {
    private AtomicInteger countOfThread = new AtomicInteger(0);
    private String prefix;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("create new Thread!!!");
        return new Thread(r,prefix + countOfThread.incrementAndGet() + "-pool：");
    }
}
