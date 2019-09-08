package com.learning.algorithms.oj;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] monthAndDay = scanner.nextLine().split(" ");
        String inputInfo = scanner.nextLine();

        int m = Integer.parseInt(monthAndDay[0]);
        int d = Integer.parseInt(monthAndDay[1]);

        String[] originalDict = new String[]{"ABCDEFGHI","JKLMNOPQR","STUVWXYZ "};
        String[] dict = new String[3];
        String[] finalDict = new String[3];

        int mLeftCount = (m - 1) % 3;
        int dLeftCount = (d - 1) % 9;
        // 先月份左移
        for (int i = 0; i < 3; i++){
            int index = (i - mLeftCount >= 0) ? i -mLeftCount : i - mLeftCount + 3;
            dict[index] =  originalDict[i];
        }
        // 按日期左移
        for (int i = 0; i < 3; i++){
            char[] currentChars = dict[i].toCharArray();
            char[] adjustChars = new char[currentChars.length];
            for (int j = 0; j < 9; j++){
                int index = (j - dLeftCount >= 0) ? j - dLeftCount : j - dLeftCount + 9;
                adjustChars[index] = currentChars[j];
            }
            finalDict[i] = String.valueOf(adjustChars);
        }


        //定位输入字符,并输出信息
        for (int i = 0; i < inputInfo.length(); i++){
            int posi = getPostion(finalDict, inputInfo.charAt(i));
            System.out.print(posi);
            if (i != inputInfo.length() - 1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // 定位函数
    private static int getPostion(String[] dict, char c){
        for (int i = 0; i < dict.length ; i++) {
            for (int j = 0; j < 9; j++){
                if (dict[i].charAt(j) == c){
                    return (i+1) * 10 + j + 1;
                }
            }

        }
        return -1;
    }
}