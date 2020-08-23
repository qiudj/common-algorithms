package com.learning.algorithms.leetcode;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 *
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author qdj
 * @date 2020/8/23 11:13
 */
public class S201 {
    public static int rangeBitwiseAnd(int m, int n) {
        int  ret = 0;
        while (true){
            int curr = (int) (Math.log(m - ret)/Math.log(2));
            if (curr == (int) (Math.log(n - ret)/Math.log(2))){
                ret += 1 << curr;
            } else {
                break;
            }
        }
        return ret;
    }

    public static int rangeBitwiseAnd2(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd2(5,7));
    }
}
