package com.learning.algorithms.dp;

import java.util.Scanner;

/**
 * 矩阵的最小路径和
 * @author qdj
 */
public class MatrixMinPathSum {
    public static int getMinPathSum(int[][] matrix, int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mn = scanner.nextLine();
        String[] mnArray = mn.split(" ");
        int m = Integer.valueOf(mnArray[0]);
        int n = Integer.valueOf(mnArray[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++){
            String curr = scanner.nextLine();
            String[] currElements = curr.split(" ");
            for (int j = 0; j < n; j++){
                matrix[i][j] = Integer.valueOf(currElements[j]);
            }
        }
        int out = getMinPathSum(matrix, m, n);
        System.out.println(out);
    }
}