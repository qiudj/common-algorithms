package com.learning.algorithms.list;

/**
 * 关于单链表的倒数第K个结点的问题
 * @author qdj
 */
public class KthLastNode {

    /** 返回删除之后的头节点 */
    public static Node deleteKthLastNode(Node head, int k){
        if (k <= 0 || head == null){
            return head;
        }

        Node first = head, second = head, prev = null;
        while (first != null && k > 0){
            first = first.next;
            k--;
        }
        if (k > 0) return head;

        while (first != null){
            first = first.next;
            prev = second;
            second = second.next;
        }

        if (prev != null){
            prev.next = second.next;
            return head;
        } else {
            // 考虑删除首节点的情况
            return head.next;
        }
    }

    public static void main(String[] args) {
        Node head = ListUtils.buildList();
        ListUtils.printList(head);

        // 删除倒数第二个元素
        Node newHead = deleteKthLastNode(head, 6);
        ListUtils.printList(newHead);
    }

}