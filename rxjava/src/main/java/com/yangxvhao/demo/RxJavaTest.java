package com.yangxvhao.demo;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Subscriber;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxvhao
 * @date 18-5-15.
 */
@Slf4j
public class RxJavaTest {
    public static void main(String[] args) {
//        integerTest();
//        create();
        interval();

    }
    
    public static void interval(){
        List<Integer> integers = new ArrayList<Integer>(){{
            add(1);add(2);add(3);add(4);
        }};
        Observable.from(integers)
                .map(integer -> add(integer))
                .flatMap(integer -> Observable.interval(2, TimeUnit.MINUTES))
                .subscribe(System.out::println);
    }
    
    
    public static void create(){
        List<Integer> integers = new ArrayList<>();
        Observable.create(subscriber -> {
            try {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 1000; i < 1005; i++) {
                        subscriber.onNext(new Integer(i));
                        log.info(String.valueOf(i));
                    }
                    subscriber.onCompleted();
                }
            }catch (Exception e){
                subscriber.onError(e);
            }
        }).map(o -> add((Integer) o))
                .filter(integer -> integer >= 3)
                .subscribe(o -> integers.add( o * 10));
        System.out.println(integers);
    }

    public static void integerTest(){
        //Integer会缓存-127~127的数据
        Integer i = 127;
        Integer tmp = i;
        try {
            Field field = tmp.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(tmp, 1000);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        add(i);
        i = i + 1;
        Integer j = i;
        System.out.println(i);
        System.out.println(j);
    }
    
    public static Integer add (Integer a){
//        a = a + 1;
        return new Integer((a) + 1);
    }
}
