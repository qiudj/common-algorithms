package com.learning.algorithms.list;

public class ListUtils {
    /*
    * 打印链表 */
    public static void printList(Node root){
        if (root == null)   return;
        System.out.print("打印链表： ");
        while (root != null){
            System.out.println(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }
}
