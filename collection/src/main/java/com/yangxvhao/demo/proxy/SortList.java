package com.yangxvhao.demo.proxy;

import lombok.Data;

/**
 * 有序链表
 * @author yangxvhao
 * @date 17-12-25.
 */

@Data
public class SortList<V extends Comparable<V>> {

    @Data
    public class Node{
        private V data;
        private Node next;

        public Node(V data){
            this.data = data;
        }
    }

    private Node firstNode;

    public void insert(V data){
        Node newNode = new Node(data);
        Node cur = firstNode, pre = null;

        while (cur != null && data.compareTo(cur.data) > 0){
            pre = cur;
            cur = cur.next;
        }
        if(pre == null){
            firstNode = newNode;
        }else {
            pre.next = newNode;
        }
        newNode.next = cur;
    }

    public SortList.Node find(V data) throws Exception {

        if(firstNode == null){
            throw new Exception("the list is empty");
        }

        SortList.Node temp = firstNode;
        while (temp.next != null){
            if(temp.data.equals(data)){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }
    public Node delete(V data){
        Node cur = firstNode, pre = null;
        if(cur.data.equals(data)){
            firstNode = cur.next;
            return firstNode;
        }
        while (cur != null){
            if(cur.data.equals(data)){
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;

        }
        return pre;
    }
    public void display() throws Exception {
        if(firstNode == null){
            throw new Exception("the list is empty");
        }
        Node temp = firstNode;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayReverse() throws Exception {
        Node p = firstNode, q = firstNode.next, t;

        while (q != null){
            t = q.next;
            if(p == firstNode){
                p.next = null;
            }
            q.next = p;
            p = q;
            q = t;
        }

        firstNode = p;
        display();
    }
}
