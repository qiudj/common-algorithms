package com.learning.algorithms.tree;

public class Sample {
    public static void main(String[] args) {


        BinaryTreeNode root = TreeUtils.buildBinaryTree();
        System.out.println(TreeUtils.isBalancedTree(root));


    }
}
