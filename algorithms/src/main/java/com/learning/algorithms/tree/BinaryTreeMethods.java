package com.learning.algorithms.tree;

import sun.reflect.generics.tree.Tree;

public class BinaryTreeMethods {
    /*判断是否是二叉搜索树*/
    public static boolean isBST(BinaryTreeNode node){
        if (node == null)   return true;
        // 判断左子树的中序遍历的最后节点值是否小于当前结点的值
        boolean flag = false;
        if (node.left != null){
            BinaryTreeNode tmp = node.left;
            BinaryTreeNode lastLeftNode = null;
            while (tmp != null){
                if (tmp.right == null){
                    lastLeftNode = tmp;
                } else {
                    lastLeftNode = tmp.right;
                }
                tmp = tmp.right; //往右找
            }
            if (node.value > lastLeftNode.value)
                flag = true;
        } else{
            flag = true;
        }

        // 判断左右子树情况
        if (node.left != null){
            flag = flag && isBST(node.left);
        }
        if (node.right != null){
            flag = flag && isBST(node.right);
        }
        return flag;
    }

    // 判断两颗树是否是一样的树
    public static boolean isSameTree(BinaryTreeNode node1, BinaryTreeNode node2){
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        return (node1.value == node2. value) &&
                isSameTree(node1.left, node2.left) &&
                isSameTree(node1.right, node1.right);
    }

    public static boolean isCompleteBinaryTree(BinaryTreeNode node){
        // 所有结点左右树高度只能是h(l) = h(r) 或者 h(l) = h(r) + 1
        if (node == null)   return true;
        int hl = TreeUtils.getTreeHeight(node.left);
        int hr = TreeUtils.getTreeHeight(node.right);
        if (!(hl == hr || hl == hr + 1))
            return false;
        return isBST(node.left) && isBST(node.right);
    }




    public static void main(String[] args) {
        System.out.println(isBST(TreeUtils.buildBinarySearchTree()));
        System.out.println(isBST(TreeUtils.buildBinaryTree()));


        System.out.println(isCompleteBinaryTree(TreeUtils.buildBinarySearchTree()));
        System.out.println(isCompleteBinaryTree(TreeUtils.buildBinaryTree()));

    }



}
