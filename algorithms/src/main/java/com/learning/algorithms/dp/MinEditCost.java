package com.learning.algorithms.dp;

/**
 * 最小编辑代价
 * @author qdj
 */
public class MinEditCost {
    public static void main(String[] args) {
        final String s1 = "abc12";
        final String s2 = "adc22";
        System.out.println(getMinEditCost(s1, s2, 5, 3, 2));
        System.out.println(getMinEditCost(s1, s2, 5, 3, 100));
    }

    /**
     * 计算最小编辑代价
     * @param s1 输入字符串1
     * @param s2 输入字符串2
     * @param ic 插入代价
     * @param dc 删除代价
     * @param rc 替换代价
     * @return s1变换为s2的最小编辑代价
     */
    public static int getMinEditCost(String s1, String s2, int ic, int dc, int rc){
        if (s1 == null || s2 == null){
            return  0;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++){
            dp[i][0] = dc * i;
        }
        for (int j = 1; j < s2.length() + 1; j++){
            dp[0][j] = ic * j;
        }

        for (int i = 1; i < s1.length() + 1; i++){
            for (int j = 1; j < s2.length() + 1; j++){
                // 因为添加“”的原因，故前移动1个下标值
                if (s1.charAt(i-1) != s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + rc;
                } else {
                    // 这种情况不需要进一步编辑
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + dc);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}