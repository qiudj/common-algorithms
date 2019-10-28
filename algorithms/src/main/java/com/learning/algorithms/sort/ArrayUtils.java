package com.learning.algorithms.sort;

import java.util.Random;

/**
 * 数组工具类
 * @author qdj
 */
public class ArrayUtils {

    public static int[] buildArray(int size) {
        if (size < 0 || size > 100){
            return null;
        }
        int[] arr = new int[size];
        int[] positionMap = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int curr = -1;
            while (true){
                curr = random.nextInt(size);
                if (positionMap[curr] == 0) {
                    break;
                }
            }
            arr[i] = curr;
            positionMap[curr] = 1;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        System.out.println("======打印数组====== ");
        for (int i = 0; i < arr.length; i++) {
            if (i % 10 == 0  && i > 0){
                System.out.println();
            }
            System.out.print(String.format("%-4d", arr[i]));
        }
        System.out.println();
    }


    /** 创建一个元素为 0~size-1 的元素不重复的有序数组 */
    public static int[] buildOrderedArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = i;
        }
        return arr;
    }

    /** 创建一个有序数组，元素可重复 */
    public static int[] buildOrderedDuplicatedArray(int size){
        int[] arr = new int[size];
        int remainder = size;

        // 使用此数产生初始值
        int currentNum = 1;
        int index = 0;
        Random random = new Random();
        while (remainder > 0){
            //每次步进1~2，范围1~remainder
            currentNum = currentNum + random.nextInt(2) + 1;
            int currentNumCounts = random.nextInt(remainder) + 1;
            remainder -= currentNumCounts;
            for (int i = 0; i < currentNumCounts; i++){
                arr[index] = currentNum;
                index++;
            }
        }
        return arr;
    }

    /** 交换数组中两个位置的元素 */
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = buildOrderedDuplicatedArray(30);
        printArray(arr);
    }

}