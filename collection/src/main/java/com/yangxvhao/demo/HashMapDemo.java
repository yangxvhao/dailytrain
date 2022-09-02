package com.yangxvhao.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.yangxvhao.demo.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jodd.util.RandomString;

/**
 * @author yangxuhao on 2022-08-25.
 */
public class HashMapDemo {

  // resize 发生丢失
  private static void task() {
    Map<Long, Boolean> contractsMap = Maps.newHashMap();
    List<CompletableFuture> futures = Lists.newArrayList();
    Lists.newArrayList(123L, 456L).forEach(uid -> {
      futures.add(CompletableFuture.runAsync(() -> {
        Boolean effect = true;
        contractsMap.put(uid, effect);
      }));
    });
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[]{})).join();
    System.out.println(contractsMap);
  }

  // hash碰撞发生丢失
  private static void test() throws InterruptedException {
    RandomString randomString = RandomString.get();
    Person testKey = new Person();
    int testCount = 10000;
    ExecutorService executorService = Executors.newFixedThreadPool(16);

    for (int i = 0; i < testCount; i++) {
      Map<Object, Object> map = new HashMap<>(8,1.0f);
      map.put(testKey, "person");

      // 并发修改map
      List<Callable<String>> taskList = new ArrayList<>();
      taskList.add(() -> {
        map.put(new Person("key1", 1), randomString.randomAlpha(8));
        return "";
      });
      taskList.add(() -> {
        map.put(new Person("key2", 2), randomString.randomAlpha(8));
        return "";
      });
      taskList.add(() -> {
        map.put(new Person("key3", 3), randomString.randomAlpha(8));
        return "";
      });
      taskList.add(() -> {
        map.put(new Person("key4", 4), randomString.randomAlpha(8));
        return "";
      });

      executorService.invokeAll(taskList);


      if (Objects.isNull(map.get(testKey))) {
        System.out.println("----------------------------- " + i + "time, parson is null");
        break;
      }

      if (i + 1 == testCount) {
        System.out.println("end");
      }
    }
    executorService.shutdown();
  }

  public static void main(String[] args) throws InterruptedException {
    for (int i = 0; i < 100; i++) {
//      task();
//      test();
    }
      test();
  }

}
