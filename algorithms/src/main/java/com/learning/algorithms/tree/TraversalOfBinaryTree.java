package com.learning.algorithms.tree;

import java.util.*;

public class TraversalOfBinaryTree {
    public static void printTree() {
        BinaryTreeNode root = TreeUtils.buildBinaryTree();
        System.out.print("\n先序遍历... ");
        TraversalOfBinaryTree.preOrderRecur(root);

        System.out.print("\n先序循环... ");
        TraversalOfBinaryTree.preOrderRecurViaLoop(root);

        System.out.print("\n中序遍历... ");
        TraversalOfBinaryTree.inOrderRecur(root);

        System.out.print("\n中序循环... ");
        TraversalOfBinaryTree.inOrderRecurViaLoop(root);


        System.out.print("\n后序遍历... ");
        TraversalOfBinaryTree.posOrderRecur(root);

        System.out.print("\n后序循环... ");
        TraversalOfBinaryTree.posOrderRecurViaLoop(root);

        System.out.print("\n层次遍历... ");
        TraversalOfBinaryTree.levelOrderRecur(root);

        System.out.print("\n层次交替... ");
        TraversalOfBinaryTree.zigzagRecur(root);

        System.out.print("\n层次交替2.. ");
        TraversalOfBinaryTree.zigzagRecur2(root);

        String serializeResult = TraversalOfBinaryTree.serializeBinaryTree(root);
        System.out.print("\n先序序列化.. " + serializeResult);

        BinaryTreeNode newRoot = TraversalOfBinaryTree.deserializeBinaryTree(serializeResult);
        System.out.print("\n重建线序... ");
        TraversalOfBinaryTree.preOrderRecurViaLoop(newRoot);
    }


    public static void preOrderRecur(BinaryTreeNode node){
        if (node == null)   return;
        System.out.print(node.value + " ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }


    public static void inOrderRecur(BinaryTreeNode node){
        if (node == null)   return;
        inOrderRecur(node.left);
        System.out.print(node.value + " ");
        inOrderRecur(node.right);
    }


    public static void posOrderRecur(BinaryTreeNode node){
        if (node == null)   return;
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.print(node.value + " ");
    }


    public static void preOrderRecurViaLoop(BinaryTreeNode root){
        if (root != null) {
            Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
            stack.push(root);
            while (!stack.isEmpty()){
                BinaryTreeNode node = stack.pop();
                System.out.print(node.value + " ");
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
    }


    public static void inOrderRecurViaLoop(BinaryTreeNode root){
        if (root != null){
            Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
            ArrayList<BinaryTreeNode> record = new ArrayList<BinaryTreeNode>();
            stack.push(root);
            while (!stack.isEmpty()){
                BinaryTreeNode node = stack.pop();
                if ((node.left == null && node.right == null) || record.contains(node)){
                    System.out.print(node.value + " ");
                } else {
                    if (node.right != null){
                        stack.push(node.right);
                    }
                    stack.push(node);
                    record.add(node);// 记录，这是取出之后又入栈的情况
                    if (node.left != null){
                        stack.push(node.left);
                    }
                }
            }
        }
    }

    public static void posOrderRecurViaLoop(BinaryTreeNode root){
        if (root != null){
            Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
            ArrayList<BinaryTreeNode> record = new ArrayList<BinaryTreeNode>();
            stack.push(root);
            while (!stack.isEmpty()){
                BinaryTreeNode node = stack.pop();
                if ((node.left == null && node.right == null) || record.contains(node)){
                    System.out.print(node.value + " ");
                } else {
                    // 后序遍历：左->右->中，需要入栈顺序相反，也就是中->右->左
                    stack.push(node);
                    record.add(node);
                    if (node.right != null){
                        stack.push(node.right);
                    }
                    if (node.left != null){
                        stack.push(node.left);
                    }
                }
            }
        }
    }


    public static void levelOrderRecur(BinaryTreeNode root){
        if (root != null){
            Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
            queue.offer(root);
            while (!queue.isEmpty()){
                BinaryTreeNode node = queue.poll();
                System.out.print(node.value + " ");
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }

    // zigzag打印
    public static void zigzagRecur(BinaryTreeNode root){
        if (root != null){
            ArrayList<BinaryTreeNode> arr1 = new ArrayList<BinaryTreeNode>();
            ArrayList<BinaryTreeNode> arr2 = new ArrayList<BinaryTreeNode>();
            arr1.add(root);

          int level = 1;
            while (arr1.size() > 0 || arr2.size() > 0){
//                System.out.print("\n第" + level + "层:");
                level++;
                if (arr1.size() > 0){
                    for (int i = 0; i < arr1.size(); i++){
                        BinaryTreeNode node = arr1.get(i);
                        System.out.print(node.value + " ");
                        if(node.left != null)
                            arr2.add(node.left);
                        if (node.right != null)
                            arr2.add(node.right);
                    }
                    arr1 = new ArrayList<BinaryTreeNode>();
                } else { // 右->左打印
                    for (int i = 0; i < arr2.size() ; i++){
                        BinaryTreeNode node = arr2.get(i);
                        if (node.left != null){
                            arr1.add(node.left);
                        }
                        if (node.right != null){
                            arr1.add(node.right);
                        }
                    }
                    for (int i = arr2.size() - 1; i >= 0; i--){
                        BinaryTreeNode node = arr2.get(i);
                        System.out.print(node.value + " ");
                    }
                    arr2 = new ArrayList<BinaryTreeNode>();
                }
            }
        }
    }

    public static void zigzagRecur2(BinaryTreeNode root){
        if (root != null){
            Deque<BinaryTreeNode> deque = new LinkedList<BinaryTreeNode>();
            deque.addLast(root);
            int flag = 1;
            while (!deque.isEmpty()){
                int currentSize = deque.size();
                if (flag == 1){ // l->r 接下来就是 r->l
                    for (int i = 0; i < currentSize; i++){
                        BinaryTreeNode node = deque.pollLast();
                        System.out.print(node.value + " ");
                        if (node.left != null)
                            deque.offerFirst(node.left);
                        if (node.right != null)
                            deque.offerFirst(node.right);
                    }
                    flag = 2;
                } else {
                    for (int i = 0; i < currentSize; i++){
                        BinaryTreeNode node = deque.pollFirst();
                        System.out.print(node.value + " ");
                        if (node.right != null)
                            deque.offerLast(node.right);
                        if (node.left != null)
                            deque.offerLast(node.left);
                    }
                    flag = 1;
                }
            }
        }
    }

    public static String serializeBinaryTree(BinaryTreeNode node){
        if (node == null)
            return "#!";
        String res = node.value + "!";
        res += serializeBinaryTree(node.left);
        res += serializeBinaryTree(node.right);
        return  res;
    }

    public static BinaryTreeNode deserializeBinaryTree(String str){
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return rebuildBinaryTreeViaPreOrder(queue);
    }

    private static BinaryTreeNode rebuildBinaryTreeViaPreOrder(Queue<String> queue){
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        BinaryTreeNode node = new BinaryTreeNode(Integer.valueOf(value));
        node.left = rebuildBinaryTreeViaPreOrder(queue);
        node.right = rebuildBinaryTreeViaPreOrder(queue);
        return node;
    }


    public static boolean isSameTree(BinaryTreeNode node1, BinaryTreeNode node2){
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        return (node1.value == node2. value) &&
                isSameTree(node1.left, node2.left) &&
                isSameTree(node1.right, node1.right);
    }


    public static void main(String[] args) {
        BinaryTreeNode tree1 = TreeUtils.buildBinaryTree();
        BinaryTreeNode tree2 = TreeUtils.buildBinaryTree();

        BinaryTreeNode tree3 = TreeUtils.buildBinaryTree();
        //修改部分结点
        tree3.left.value = 99;

        System.out.println(isSameTree(tree1, tree2));
        System.out.println(isSameTree(tree1, tree3));
    }
}
