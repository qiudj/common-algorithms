package com.learning.algorithms.sort;

public class Sort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null)
            return null;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j,j + 1);
                    flag = true; //本次发生交换
                }
            }
            if (!flag) break;
        }
        return arr;
    }

    public static int[] selectSort(int[] arr) {
        if (arr == null) return null;
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minPos]) {
                    minPos = j;
                }
            }

            //交换i处的元素与后面最小的元素。
            if (minPos != i) {
                swap(arr, i, minPos);
            }
        }
        return arr;
    }


    public static int[] insertSort(int[] arr){
        if (arr == null)    return null;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j > 0 ; j--){
                if (arr[j] < arr[j-1]){
                    swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        if (arr != null){
            int[] tmp = new int[arr.length];
            mergeSort(arr, 0, arr.length - 1, tmp);
        }
        return arr;
    }

    public static void mergeSort(int[] arr, int first, int last, int[] tmp){
        if (first < last){
            int mid = (first + last) >> 1;
            mergeSort(arr, first, mid, tmp);
            mergeSort(arr, mid+1, last, tmp);
            mergeArray(arr, first, mid, last, tmp);
        }
    }
    public static void mergeArray(int[] arr, int first, int middle, int end, int[] tmp){
        int l = first;
        int r = middle+1;
        int k = 0;

        while (l <= middle && r <= end){
            if (arr[l] <= arr[r]){
                tmp[k] = arr[l];
                l++;
            } else {
                tmp[k] = arr[r];
                r++;
            }
            k++;
        }

        while (l<=middle){
            tmp[k] = arr[l];
            k++;
            l++;
        }

        while (r<=end){
            tmp[k] = arr[r];
            k++;
            r++;
        }

        for (int i = 0; i < k; i++){
            arr[first + i] = tmp[i];
        }
    }

    //交换数组中两个位置的元素
    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }


    public static void main (String[]args){
        int[] arr = ArrayBuilder.builerArray(22);
        ArrayBuilder.printArray(arr);

//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
        mergeSort(arr);
        ArrayBuilder.printArray(arr);
    }
}