package pool;

import java.sql.SQLOutput;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yangxuhao
 * @date 2019-06-10 18:00.
 */
public class MyRejectedHandler implements RejectedExecutionHandler {
    private MyThreadFactory myThreadFactory = new MyThreadFactory("myThread-rejected-");

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("rejected, create new Thread");
        myThreadFactory.newThread(r).start();
    }
}
