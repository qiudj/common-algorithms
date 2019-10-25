package com.learning.algorithms.dp;

/**
 * 最长公共子串
 * @author qdj
 */
public class LongestCommonSubString {
    public static String getLongestCommonSubString(String str1, String str2){
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)){
            return "";
        }
        int[][] dp = getDpArray(str1, str2);
        int max = 0;
        int end = 0;
        for (int i = 0; i < str1.length(); i++){
            for (int j = 0; j < str2.length(); j++){
                if (dp[i][j] > max){
                    max = dp[i][j];
                    // 最终结果从str1中取出
                    end = i;
                }
            }
        }
        return str1.substring(end - max + 1, end + 1);
    }

    /** 获取动态规划表 */
    private static int[][] getDpArray(String str1, String str2){
        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < str2.length(); j++){
            if (str1.charAt(0) == str2.charAt(j)){
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < str1.length(); i++){
            for (int j = 1; j < str2.length(); j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str1 = "12312abc";
        String str2 = "56712ab37";
        System.out.println("最长公共子串是：" + getLongestCommonSubString(str1, str2));
    }
}