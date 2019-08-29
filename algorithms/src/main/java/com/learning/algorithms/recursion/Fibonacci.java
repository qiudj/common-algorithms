package com.learning.algorithms.recursion;

/**
 * 斐波那契数列的递归实现和非递归实现
 */
public class Fibonacci {

    public static int fib1(int n){
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n){
        if (n < 1)  return 0;
        if (n == 1 || n == 2)   return 1;
        int tmp = 0;
        int result = 1;
        int prev = 1;
        for (int i = 3; i <= n; i++){
            tmp = result;
            result = result + prev;
            prev = tmp;
        }
        return result;
    }

    /**
     * 类似的问题：跳台阶
     * @param n 表示台阶数
     */
    public static int getWaysCount(int n){
        if (n < 1)  return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int tmp, res = 1, prev = 2;
        for (int i = 3; i <= n; i++){
            tmp = prev;
            res = res + prev;
            prev = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(10));
    }
}