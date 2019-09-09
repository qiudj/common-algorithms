package com.learning.algorithms.list;

public class ListUtils {
    /*
    * 打印链表 */
    public static void printList(Node root){
        if (root == null)   return;
        System.out.println("打印链表： ");
        while (root != null){
            System.out.print(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }

    /* 创建单向链表1->2->3->4->5->6，并返回头结点*/
    public static Node buildList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        return  node1;
    }
}
