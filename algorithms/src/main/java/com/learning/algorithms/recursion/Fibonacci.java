package com.learning.algorithms.recursion;

/**
 * 斐波那契数列的递归实现和非递归实现
 * @author qdj
 */
public class Fibonacci {
    /** 递归方法解决斐波拉契问题 */
    public static int fib1(int n){
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    /** 非递归方法解决斐波拉契问题 */
    public static int fib2(int n){
        if (n < 1)  return 0;
        if (n == 1 || n == 2)   return 1;
        int tmp, result = 1, prev = 1;
        for (int i = 3; i <= n; i++){
            tmp = result;
            result = result + prev;
            prev = tmp;
        }
        return result;
    }

    /**
     * 类似问题：跳台阶
     * @param n 表示台阶数
     */
    public static int getWaysCount(int n){
        if (n < 1)  return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 1, prev = 2;
        for (int i = 3; i <= n; i++){
            res = res + prev;
            prev = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(10));
        System.out.println(getWaysCount(8));
    }
}