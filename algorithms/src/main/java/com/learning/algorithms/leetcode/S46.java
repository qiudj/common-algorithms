package com.learning.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法

// 全排列树形结构 递归树  BFS和DFS
public class S46 {
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public List<Integer> toList(int[] arr){
        // deep copy.
        List<Integer> list = new ArrayList<Integer>(arr.length);
        for (int n : arr){
            list.add(n);
        }
        return list;
    }

    public void backtrack(int[] arr,
                          List<List<Integer>> res,
                          int first) {
        if (first == arr.length)
            res.add(toList(arr));
        for (int i = first; i < arr.length; i++) {
            swap(arr, first, i);
            backtrack(arr, res, first + 1);
            //back 逆操作
            swap(arr, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtrack(nums, res, 0);
        return res;
    }

    public static void main(String[] args) {
        S46 s = new S46();
        int[] nums = new int[]{1,2,3};
        s.permute(nums);
    }
}
