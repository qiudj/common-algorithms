package com.learning.algorithms.leetcode;

public class S24 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head, second = head.next;
        ListNode newHead = second;
        while (true){
            ListNode tmp = second.next;
            second.next = first;
            if (tmp == null || tmp.next == null){
                first.next = tmp;
                break;
            }
            first.next = tmp.next;
            first = tmp;
            second = tmp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
        node1.next=node2;
        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
//        node5.next=node6;

        printList(node1);
        printList(swapPairs(node1));

    }
    private static void printList(ListNode root){
        if (root == null)   return;
        System.out.println("打印链表： ");
        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }
}
