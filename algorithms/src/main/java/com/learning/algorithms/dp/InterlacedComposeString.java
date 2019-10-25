package com.learning.algorithms.dp;

/**
 * 字符串交替组成，三个字符串s1,s2,aim,判断aim是否包含且仅包含s1和s2的所有字符；
 * 且在aim中s1和s2各字符维持原来的顺序。
 * @author qdj
 */
public class InterlacedComposeString {

    public static boolean isInterlacedComposed(String s1, String s2, String aim){
        if (s1 == null || s2 == null || aim == null){
            return false;
        }
        if (s1.length() + s2.length() != aim.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length() + 1; i++){
            if (s1.charAt(i-1) != aim.charAt(i-1)){
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j < s2.length() + 1; j++){
            if (s2.charAt(j-1) == aim.charAt(j-1)){
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i < s1.length() + 1; i++){
            for (int j = 1; j < s2.length() + 1; j++) {
                if ((dp[i - 1][j] && s1.charAt(i - 1) == aim.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == aim.charAt(i + j - 1))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "123";
        String aim1 = "AB123C";
        String aim2 = "AB231C";
        System.out.println(isInterlacedComposed(s1, s2, aim1));
        System.out.println(isInterlacedComposed(s1, s2, aim2));
    }
}