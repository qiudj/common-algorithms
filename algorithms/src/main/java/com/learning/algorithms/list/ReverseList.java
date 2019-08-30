package com.learning.algorithms.list;

public class ReverseList {
    public static Node reverseList(Node root){
        if (root == null)   return null;
        Node next = null;
        Node node = root;
        Node prev = null;


//      prev ---> node --->next

        while (node != null){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
