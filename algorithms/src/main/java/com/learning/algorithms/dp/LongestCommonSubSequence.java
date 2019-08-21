package com.learning.algorithms.dp;

//最长公共子序列
public class LongestCommonSubSequence {
    public static void main(String[] args) {

    }
    public int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = (str1[0] == str2[0] ? 1 : 0);
        for (int i = 1; i < str1.length; i++){
            dp[i][0] = Math.max(str1[i] == str2[0] ? 1 : 0, dp[i-1][0]);
        }
        for (int j = 1; j< str2.length; j++){
            dp[0][j] = Math.max(str1[0] == str2[j] ? 1 : 0, dp[0][j-1]);
        }

        for (int i = 1; i < str1.length; i++){
            for (int j = 1; j < str2.length; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (str1[i] == str2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp;
    }
}
