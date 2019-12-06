package com.learning.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * level : easy
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author qdj
 * @date: 2019-12-05 18:55
 *
 * 分析：把每一次的各位置平方求和放到set中，若某一次各位置平方和在之前出现过，就说明后面会进入循环变不到1。
 **/
public class S202HappyNumber {
    public static void main(String[] args) {
        S202HappyNumber test = new S202HappyNumber();
        System.out.println(test.isHappy(19));
        System.out.println(test.isHappy(34));
        System.out.println(test.isHappy(10000));

    }

    public boolean isHappy(int n) {
        Set<Integer> records = new HashSet<Integer>();
        while (n > 0){
            int currentSum = getSum(n);
            if (currentSum == 1){
                return true;
            } else if (records.contains(currentSum)){
                return false;
            } else {
                records.add(currentSum);
            }
            n = currentSum;
        }
        return false;
    }

    /** 给出一个正整数各个位置的和 */
    public int getSum(int m){
        int sum = 0;
        while (m > 0){
            sum = sum + (m%10) * (m%10);
            m /= 10;
        }
        return sum;
    }
}
