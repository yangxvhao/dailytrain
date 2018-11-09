import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author yangxvhao
 * @date 18-5-2.
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Map<String, String> map = new LRU();
//        for(int i = 0; i < 13; i ++)
//            map.put("aaa" + i, "aaa" + i);
//
//        System.out.println(map.get("aaa7"));
//        System.out.println(map.size());
//        map.put("bbb", "bbb");
//        map.put("ccc", "ccc");
//        map.put("ddd", "ddd");
//        map.put("eee", "eee");
//        Set<String> set = new HashSet();
//        map = new LinkedHashMap<>();
//        map.put("","");
        
        Method m = Widget.class.getDeclaredMethod("setString", java.lang.String.class);
        Widget widget = new Widget();
        m.invoke(widget, "name");
        Map s = new IdentityHashMap();
        final String[] str = {""};
        str[9] = "";
        final Widget widget0 = new Widget();
        final Widget widget1 = new Widget();
        widget.setString("");
        
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
