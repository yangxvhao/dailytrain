package com.yangxvhao.demo;

/**
 * @author yangxvhao
 * @date 17-12-21.
 */

public class SkipListNode<K,V> {
    public K key;
    public V value;

    public SkipListNode<K,V>[] next;
}
