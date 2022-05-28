package pool;

import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @author yangxuhao
 * @DATE 2020-10-10 16:42.
 */
public class ThreadPoolSubmitTest {

  public static void main(String[] args) {
    ExecutorService executorService = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
    Map<Integer, Future<Integer>> resultMap = Maps.newHashMap();
    for (int i = 0; i < 100; i++) {
      int finalI = i;
      resultMap.put(i, executorService.submit(() -> {
        Thread.sleep(100);
        if(finalI % 10 == 0){
          throw new Exception();
        }
        System.out.println(LocalDate.now().atStartOfDay() + "----count:----" + finalI + "----");
        return 100;
      }));
    }
//    Map<Integer, Integer> integerMap = resultMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, integerFutureEntry -> {
//      try {
//        integerFutureEntry.getValue().get(1000, TimeUnit.MILLISECONDS);
//      } catch (InterruptedException | ExecutionException | TimeoutException e) {
//        e.printStackTrace();
//      }
//      return 1;
//    }));
//    System.out.println(integerMap);
    executorService.shutdown();
  }
}
