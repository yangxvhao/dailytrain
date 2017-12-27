package com.yangxvhao.demo;

import lombok.Data;

import java.util.ArrayList;
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
            temp = new SkipListNode<V>(Double.MIN_VALUE, null);
            temp.down = prev;
            prev = temp;
        }
        head = temp;
    }
//    @Data
    public class SkipListNode<T> {
        public double key;
        public T value;
        public SkipListNode<T> next, down;

        public SkipListNode(double key, T value) {
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

    public void insert(double key, V value) {
        SkipListNode<V> t = head, cur = null;
        /**
         * 用path记录查找路径，新加节点时可以更方便添加
         */
        ArrayList<SkipListNode<V>> path = new ArrayList<>();
        /**
         *
         * 先查找一遍是否有存在的key，更新value即可
         */
        while (t != null) {
            if (t.key == key) {
                cur = t;
                break;
            }
            if (t.next == null) {
                path.add(t);
                if (t.down != null) {
                    t = t.down;
                    continue;
                } else {
                    break;
                }
            }
            if (t.next.key > key) {
                path.add(t);
                if (t.down == null) {
                    break;
                }
                t = t.down;
            } else {
                t = t.next;
            }
        }
        /**
         * cur不等于空说明key已经存在，更新value
         */
        if (cur != null) {
            while (cur != null) {
                cur.value = value;
                cur = cur.down;
            }
        } else {
            int level = RandamLevel();
//            System.out.println(level);
            /**
             * 如果随机生成的level大于现在的level,需要增加head,替换path的第一个节点
             */
            if (level > this.level) {
                SkipListNode temp = null;
                SkipListNode prev = head;
                while (this.level++ != level){
                    temp = new SkipListNode(Double.MIN_VALUE,null);
                    path.add(0,temp);
                    temp.down = prev;
                    prev = temp;
                }
                head = temp;
                this.level = level;
            }
            SkipListNode downTemp = null, temp = null, prev = null;
            for (int i = this.level - 1; i >= this.level - level; i--) {
                temp = new SkipListNode(key, value);
                prev = path.get(i);
                temp.next = prev.next;
                prev.next = temp;
                temp.down = downTemp;
                downTemp = temp;
            }

        }
    }

    /**
     * 根据key删除节点
     * @param key
     */
    public void delete(double key){
        /**
         * step1:查找到要删除节点的前一个节点
         */
        SkipListNode t = findNode(key);
        if(t == null || t.next == null){
            return;
        }
        /**
         * step2:替换
         */
        while (t != null){
            t.next = t.next.next;
            t = t.down;
        }
    }

    public SkipListNode<V> findNode(double key){
        SkipListNode<V> t = head;
        while (t != null){
            if(t.next == null){
                t = t.down;
                continue;
            }
            if(t.next.key == key){
                break;
            }
            if(t.next.key > key){
                t = t.down;
                continue;
            }else {
                t = t.next;
            }
        }
        return t;
    }


    public V get(double key){
        SkipListNode<V> t = findNode(key);
        if(t == null){
            return null;
        }else if(t.next.key == key) {
            return t.next.value;
        }
        return null;
    }

    public void display(){
        StringBuilder sb = new StringBuilder();
        SkipListNode skipListNode = head, next = null;
        while (skipListNode != null){
            next = skipListNode;
            while (next != null){
                sb.append("(" + next.key + "," + next.value + ")" + "->");
                next = next.next;
            }
            sb.append("\n");
            skipListNode = skipListNode.down;
        }
        System.out.println(sb);
    }

}
