package com.learning.algorithms.dp;

/**
 * 最长公共子序列
 */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        // 测试字符串
        String str1 = "1a2c3d4b56ahjklnm";
        String str2 = "b1d23ca45b6aln2iopnm";
        System.out.println(longCommonSequence(str1, str2));
    }

    /* 获取动态规划表 */
    private static int[][] getDp(char[] str1, char[] str2){
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

    public static String longCommonSequence(String str1, String str2){
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")){
            return "";
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = getDp(chars1, chars2);
        int m = chars1.length - 1;
        int n = chars2.length - 1;

        char[] result = new char[dp[m][n]];
        int index = result.length - 1;
        while (index >= 0){
            if (n > 0 && dp[m][n] == dp[m][n-1]){
                n--;
            } else if (m > 0 && dp[m][n] == dp[m-1][n]){
                m--;
            } else {
                result[index--] = chars1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(result);
    }
}
