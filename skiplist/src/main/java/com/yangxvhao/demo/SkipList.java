package com.yangxvhao.demo;

import lombok.Data;

import java.util.Random;

/**
 * @author yangxvhao
 * @date 17-12-25.
 */
@Data
public class SkipList<V> {

    /**
     * 跳表效率最好的最大层数32
     */
    private static int MAX_LEVEL = 1 << 5;
    private int level;
    private SkipListNode<V> head;

    public SkipList(){
        this(4);
    }

    public SkipList(int level){
        this.level = level;
        SkipListNode<V> temp = null, prev = null;
        for (int i = 0; i < level; i ++){
            temp = new SkipListNode<>(null,Double.MIN_VALUE);
            temp.down = prev;
            prev = temp;
        }
        head = temp;
    }
    @Data
    public class SkipListNode<V> {
        public double key;
        public V value;
        public SkipListNode<V> next, down;

        public SkipListNode(V value, double key) {
            this.value = value;
            this.key = key;
        }
    }

    public int RandamLevel(){
        int level = 1;
        while (new Random().nextInt() % 2 == 0){
            level ++;
        }
        return level > MAX_LEVEL ? MAX_LEVEL : level;
    }

    public void insert(double key, V value){
        SkipListNode<V> t = head, cur = null;
        while (t != null){
            if(t.getKey() == key){
                cur = t;
                break;
            }
            if(t.next == null){
                if(t.down != null){
                    t = t.down;
                    continue;
                }
            }else {
                break;
            }
            if(t.next.getKey() > key){

            }
        }
    }

}
