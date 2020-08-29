package com.learning.algorithms.leetcode;


//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
//
// 示例 1:
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
// 示例 2:
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.


//        for (int i = 0; i < nums.length; i++){
//            dp[i][0] = false;
//        }

// dp[i][j]表示前i个元素是否可以挑选出子序列使其和为j


public class S416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int j = 0; j <= target; j++){
            if (nums[0] == j){
                dp[0][j] = true;
            }
        }
        for(int i = 1; i< nums.length;i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i]];
                }
            }
            //剪枝
            if (dp[i][target]) return true;

        }
        return dp[nums.length - 1][target];
    }

    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        for (int j = 0; j <= target; j++){
            if (nums[0] == j){
                dp[j] = true;
            }
        }
        for(int i = 1; i< nums.length;i++) {
            for (int j = target; j > 0; j--) {
                if (dp[target]) return true;
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        System.out.println(canPartition2(nums));
    }
}
