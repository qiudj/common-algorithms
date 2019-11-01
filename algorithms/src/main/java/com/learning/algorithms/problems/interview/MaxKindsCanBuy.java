package com.learning.algorithms.problems.interview;

import java.util.Scanner;

/**
 * @description: 给定不重复的商品价格数组和预算，要求给出买的商品种类最多且不超过预算的消费总额
 * @author: qdj
 * @date: 2019-11-01 10:20
 **/
public class MaxKindsCanBuy {

    public static void main(String[] args) {
        // 输入商品价格数组(价格无序)
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

        //
        for (int i = 0; i < itemPriceArray.length; i++){
            sum += itemPriceArray[i];
            if (sum > maxCost){
                sum = sum - itemPriceArray[i];
                break;
            }
        }
        System.out.println(sum);
    }

    /** 快速排序 */
    public static void quickSort(int[] arr){
        partition(arr, 0, arr.length - 1);
    }
    private static void partition(int[] arr, int start, int end){
        int low = start, high = end;
        if (low >= high){
            return;
        }
        int pivotVal = arr[low];
        while (low < high){
            while (arr[high] >= pivotVal && (low < high)){
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (arr[low] <= pivotVal && (low < high)){
                low++;
            }
            if (low < high){
                arr[high] = arr[low];
                high--;
            }

        }
        arr[low] = pivotVal;
        partition(arr, start,low - 1 );
        partition(arr, low + 1, end);
    }

}
