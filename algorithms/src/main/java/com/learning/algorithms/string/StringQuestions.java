package com.learning.algorithms.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StringQuestions {


    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            char[] chars = str.toCharArray();

            func(chars, 0);

        }*/

        Queue<String> queue = new LinkedList<String>();
        queue.offer("2222");

        System.out.println(queue.size());


    }



    // 1.给定位置，切分字符串，交换前后两部分的位置
    public static String reverseString(String in, int pos){
        if (in == null || pos >= in.length() || pos <= 0) { //输入的边界检查
            return in;
        }
        StringBuilder sb = new StringBuilder();
        int rightMin = pos; //索引
        int leftMax = pos - 1;
        for (int i = rightMin; i < in.length(); i++){
            sb.append(in.charAt(i));
        }
        for (int i = 0; i <= leftMax; i++){
            sb.append(in.charAt(i));
        }

        System.out.println("输入：" + in + " | 调整位置： " + pos);
        System.out.println("输出：" + sb.toString());

        return sb.toString();
    }


    // 2. a b c 三个布尔型变量，至少两个为真的时候返回true，否则返回false，要求一句语句。
    public static boolean isTrue(boolean a, boolean b, boolean c){
        return (a && b) || (a && c) || (b && c);
    }


    // 3.输出二进制表示中1的个数
    public static void printBinaryOfNumber(int num){
        int n = num;
        for (int i = 0; i < 32; i++) {
            System.out.print(n & 1);
            n = n >> 1;
        }
    }
    // 高位的0将不再打印
    public static void printBinaryOfNumber2(int num){
        int n = num;
        do {
            System.out.print(n & 1);
            n = n>>1;
        }while (n != 0);
    }

    //4.打印几个字母的全排列  用递归来做..
    private static void func(char[] chars, int pos){
        if(pos == chars.length - 1){
            System.out.println(String.valueOf(chars));
        } else {
            for (int i = pos; i < chars.length; i++){
                //交换两个位置的值...
                swap(chars, i, pos);

                // 递归调用
                func(chars, pos + 1);
                swap(chars, pos, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

