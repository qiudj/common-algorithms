package com.learning.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 有关于二叉树路径和的几个问题
 * @date 2019年9月8日23:36:21
 */
public class BinaryTreePath {

    /* 符合和为给定数字的二叉树所有路径 */
    public static LinkedList<LinkedList<BinaryTreeNode>> getAllPath(BinaryTreeNode node, int sum){
        LinkedList<LinkedList<BinaryTreeNode>> result = new LinkedList<LinkedList<BinaryTreeNode>>();
        LinkedList<BinaryTreeNode> pathRecord = new LinkedList<BinaryTreeNode>();

        getPath(node, sum,pathRecord,result);
        return result;
    }

    private static void getPath(BinaryTreeNode node, int n, List<BinaryTreeNode> pathRecord,
                        LinkedList<LinkedList<BinaryTreeNode>> reslut){
        //1. 先加入当前结点
        pathRecord.add(node);
        // 1.1当前结点是叶子节点时，进行处理
        if (node.left == null && node.right == null){
            if (n == node.value){
                LinkedList<BinaryTreeNode> matchedPath = new LinkedList<BinaryTreeNode>();
                // 保存路径
                for (int i = 0; i < pathRecord.size(); i++)
                    matchedPath.add(pathRecord.get(i));
                reslut.add(matchedPath);
            }
            pathRecord.remove(node);
        }
        // 1.2 当前结点非叶子节点，递归调用，处理左右子树
        if (node.left != null) {
            getPath(node.left, n - node.value, pathRecord, reslut);
        }
        if (node.right != null){
            getPath(node.right, n - node.value,pathRecord , reslut);
        }

        //2. 移除当前结点
        pathRecord.remove(node);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = TreeUtils.buildBinaryTree();
        LinkedList<LinkedList<BinaryTreeNode>> result = getAllPath(root, 15);

        // 打印所有符合要求的路径
        for (int i = 0; i < result.size(); i++){
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j).value);
                if (j != result.get(i).size() - 1){
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }
}