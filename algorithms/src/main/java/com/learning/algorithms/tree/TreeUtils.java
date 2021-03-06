package com.learning.algorithms.tree;

public class TreeUtils {

    public static boolean isBalancedTree(BinaryTreeNode node){
        if (node == null)
            return true;
        return isBalanced(node) && isBalanced(node.left) && isBalanced(node.right);
    }
    public static int getTreeHeight(BinaryTreeNode node){
        if (node == null)   return 0;
        return 1 + Math.max(getTreeHeight(node.left), getTreeHeight(node.right));
    }
    private static boolean isBalanced(BinaryTreeNode node){
        if (node == null){
            return true;
        }
        if (Math.abs(getTreeHeight(node.left) - getTreeHeight(node.left)) > 1){
            return false;
        }
        return true;
    }





    public static BinaryTreeNode buildBinaryTree(){
        /*
         *        1
         *     2     3
         *  4    5  6  7
         *8  9           10
         */
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(12); //5
        BinaryTreeNode node6 = new BinaryTreeNode(11); //6
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(4); //10

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node7.right = node10;
        return node1;
    }

    public static BinaryTreeNode buildBinarySearchTree(){
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(20);
        BinaryTreeNode node3 = new BinaryTreeNode(30);
        BinaryTreeNode node4 = new BinaryTreeNode(40);
        BinaryTreeNode node5 = new BinaryTreeNode(50);
        BinaryTreeNode node6 = new BinaryTreeNode(60);
        BinaryTreeNode node7 = new BinaryTreeNode(70);

        node4.left = node3;
        node4.left = node6;
        node3.left = node1;
        node3.right = node2;

        node6.left = node5;
        node6.right = node7;
        /*                     40
         *                30       60
         *              20   10  50   70
         */
        return node1;
    }
}
