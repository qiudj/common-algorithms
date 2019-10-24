package com.learning.algorithms.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 此LRU缓存实现对于更新值，不算作一次访问
 */
public class LRUCache2 {

    public class Node{
        Node prev, next;
        int key, value;
        public Node(){}
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /**
       key int; value Node {prev,next,val}
     */
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cacheSize;

    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<Integer, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        // 取到，移动元素为head； 没有返回-1
        Node node = map.get(key);
        if (node != null){
            moveNodeToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int val){
        //放的时候放在首部，更新的时候不算访问
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = val;
        } else {
            if (map.size() >= cacheSize){
                //删除最后一个元素
                removeLast();
            }
            Node node = new Node(key,val);
            placeNodeToHead(node);
            map.put(key, node);
        }
    }

    private void moveNodeToHead(Node node){
        // 首先修复原位置的前后引用关系
        Node oldPrev = node.prev;
        Node oldNext = node.next;
        oldPrev.next = oldNext;
        oldNext.prev = oldPrev;
        // 移动到头部
        placeNodeToHead(node);

    }

    private void placeNodeToHead(Node node){
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void removeLast(){
        Node last = tail.prev;
        map.remove(last.key);
        for (Map.Entry<Integer,Node> entry: map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue().value + " ");
        }
        Node prevOfLast = last.prev;
        prevOfLast.next = tail;
        tail.prev = prevOfLast;
    }


    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.valueOf(scanner.nextLine().trim());
        LRUCache2 instance = new LRUCache2(capacity);

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (capacity >0 && command.charAt(0) == 'p') {
                int key = Integer.valueOf(command.substring(2, command.lastIndexOf(" ")));
                int value = Integer.valueOf(command.substring(command.lastIndexOf(" ")+1));
                instance.put(key, value);
            }else if(command.charAt(0) == 'g') {
                if (capacity <= 0) {
                    System.out.println(-1);
                }else {
                    int key = Integer.valueOf(command.substring(2));
                    System.out.println(instance.get(key));
                }
            }
        }
    }
}
