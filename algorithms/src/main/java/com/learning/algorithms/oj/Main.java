package com.learning.algorithms.oj;

import java.util.Scanner;

/**
 * 想买的种类最多，意味着将价格排成升序，从低价格开始走，直到超过价格上限
 * 就可以解出答案
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int maxCost = Integer.parseInt(scanner.nextLine());
        String[] itemPriceStringArray = scanner.nextLine().split(" ");
        int[] itemPriceArray = new int[itemPriceStringArray.length];
        for (int i = 0; i < itemPriceStringArray.length; i++){
            itemPriceArray[i] = Integer.parseInt(itemPriceStringArray[i]);
        }

        // 对价格进行排序
        int sum = 0;
        quickSort(itemPriceArray);
        for (int i = 0; i < itemPriceArray.length; i++){
            sum += itemPriceArray[i];
            if (sum > maxCost){
                sum = sum - itemPriceArray[i];
                break;
            }
        }
        System.out.println(sum);
    }

    //快速排序
    public static void quickSort(int[] arr){
        partition(arr, 0, arr.length - 1);
    }
    private static void partition(int[] arr, int start, int end){
        int l = start, h = end;
        if (l >= h)   return;
        int pivotVal = arr[l];

        while (l < h){
            while (arr[h] >= pivotVal && (l < h)){
                h--;
            }
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }
            while (arr[l] <= pivotVal && (l < h)){
                l++;
            }
            if (l < h){
                arr[h] = arr[l];
                h--;
            }

        }
        arr[l] = pivotVal;
        partition(arr, start,l - 1 );
        partition(arr, l + 1, end);
    }
}