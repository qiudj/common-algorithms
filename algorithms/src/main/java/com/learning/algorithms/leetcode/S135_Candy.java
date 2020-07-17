package com.learning.algorithms.leetcode;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S135_Candy {

    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int[] cnt = new int[ratings.length];
        cnt[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                cnt[i] = cnt[i-1] + 1;
            } else {
                cnt[i] = 1;
            }
        }
        for (int j = ratings.length - 2; j >= 0 ; j--){
            if (ratings[j] > ratings[j+1] && cnt[j] <= cnt[j+1]){
                cnt[j] = cnt[j+1] + 1;
            }
        }
        int sum = 0;
        for (int k = 0; k < cnt.length; k++) {
            sum += cnt[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        S135_Candy instance = new S135_Candy();
        System.out.println(instance.candy(new int[]{1,0,2}));//5
        System.out.println(instance.candy(new int[]{1,2,2}));//4
        System.out.println(instance.candy(new int[]{1,3,4,5,2})); //11
    }
}
