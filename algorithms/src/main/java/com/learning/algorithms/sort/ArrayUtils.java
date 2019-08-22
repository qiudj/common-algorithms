package com.learning.algorithms.sort;

import java.util.Random;

public class ArrayUtils {
    public static int[] buildArray(int size) {
        if (size < 0 || size > 100){
            return null;
        }
        int[] arr = new int[size];
        int[] positionmap = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int curr = -1;
            while (true){
                curr = random.nextInt(size);
                if (positionmap[curr] == 0)
                    break;
            }
            arr[i] = curr;
            positionmap[curr] = 1;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        if (arr == null)
            return;
        System.out.print("\n数组元素.. ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtils.buildArray(1);
        ArrayUtils.printArray(array);
    }
}