package com.yangxvhao.demo;

import lombok.Data;

/**
 * 单链表
 * @author yangxvhao
 * @date 17-12-25.
 */

@Data
public class LinkedList<V> {

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

        Node node = new Node(data);
        node.next = firstNode;
        firstNode = node;
    }

    public Node find(V data) throws Exception {

        if(firstNode == null){
            throw new Exception("the list is empty");
        }

        Node temp = firstNode;
        while (temp.next != null){
            if(temp.data.equals(data)){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * 链表中有多个相同值，删除第一个
     * @param data
     * @throws Exception
     */
    public void delete(V data) throws Exception {
        if(firstNode == null){
            throw new Exception("the list is empty");
        }

        if(firstNode.data.equals(data)){
            firstNode = firstNode.next;
        }else {
            Node pre = firstNode;
            Node cur = firstNode.next;
            while (cur != null){
                if(cur.data.equals(data)){
                    pre.next = cur.next;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void display(){
        if(firstNode == null){
            System.out.println("the list is empty");
        }else {
            Node cur = firstNode;
            while (cur != null){
                System.out.print(cur.data + "->");
                cur = cur.next;
            }
            System.out.println();
        }

    }
}
