package com.learning.algorithms.leetcode;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// 示例:
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
// 进阶:
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

public class S53 {
    public static int maxSubArray(int[] nums){
        // dp[i]表示以第i个元素结尾的子序列的最大和
        int[] dp = new int[nums.length];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static int maxSubArray2(int[] nums){
        // dp[i]表示前i个元素的连续子序列的最大和
        // 这是一种错误的思路
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int last = 0;
        for (int i = 1; i < nums.length; i++){
            dp[i] = dp[i-1];
            if (last == i -1){
               if (nums[i] > 0){
                   last = i;
                   dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
               } else {
                   if (nums[i] > dp[i-1]){
                       dp[i] = nums[i];
                       last = i;
                   }
               }
            } else {
                if (nums[i] > 0){
                    int sum = 0;
                    for (int j = last + 1; j<=i; j++){
                        sum += nums[j];
                    }
                    if (sum > 0){
                      last = i;
                      dp[i] = Math.max(dp[i-1] + sum, nums[i]);
                    } else {
                        if (nums[i] > dp[i-1]){
                            dp[i] = nums[i];
                            last = i;
                        }
                    }
                } else {
                    if (nums[i] > dp[i-1]){
                        dp[i] = nums[i];
                        last = i;
                    }
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = new int[]{8,-19,5,-4,20};
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray2(nums2));
    }
}
