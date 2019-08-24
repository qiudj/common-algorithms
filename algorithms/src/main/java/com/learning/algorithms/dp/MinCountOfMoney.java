package com.learning.algorithms.dp;

/**
 * 换钱的最少货币数
 */
public class MinCountOfMoney {
    public static int getMinCountOfMoney(int[] moneyArr, int aimMoney){
        int[][] dp = new int[moneyArr.length][aimMoney+1];
        for (int j = 1; j < aimMoney + 1; j++){
            dp[0][j] = Integer.MAX_VALUE;
            if (j % moneyArr[0] == 0){
                dp[0][j] = j / moneyArr[0];
            }
        }
        for (int i = 1; i < moneyArr.length; i++){
            for (int j = 1; j < aimMoney + 1; j++){
                int tmp = Integer.MAX_VALUE;
                if (j - moneyArr[i] >= 0 && dp[i][j-moneyArr[i]] != Integer.MAX_VALUE){
                    tmp = dp[i][j - moneyArr[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i-1][j], tmp);
            }
        }
        return dp[moneyArr.length-1][aimMoney] ==
                Integer.MAX_VALUE ? -1 : dp[moneyArr.length-1][aimMoney];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3};
        int out = getMinCountOfMoney(arr, 10);
        System.out.println(out); //输出2
    }
}