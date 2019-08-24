package com.learning.algorithms.sort;

public class Sort {
    public static int[] bubbleSort(int[] arr) {
        if (arr == null)
            return null;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtils.swap(arr, j,j + 1);
                    flag = true; //优化：如果一趟循环中没有发生变换，说明已经有序
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
                ArrayUtils.swap(arr, i, minPos);
            }
        }
        return arr;
    }


    public static int[] insertSort(int[] arr){
        if (arr == null)    return null;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = i + 1; j > 0 ; j--){
                if (arr[j] < arr[j-1]){
                    ArrayUtils.swap(arr, j, j - 1);
                }
            }
        }
        return arr;
    }

    public static void mergeSort(int[] arr){
        if (arr != null){
            int[] tmp = new int[arr.length];
            mergeSort(arr, 0, arr.length - 1, tmp);
        }
    }

    public static void mergeSort(int[] arr, int first, int last, int[] tmp){
        if (first < last){
            int mid = (first + last) >> 1;
            mergeSort(arr, first, mid, tmp);
            mergeSort(arr, mid+1, last, tmp);
            mergeArray(arr, first, mid, last, tmp);
        }
    }
    public static void mergeArray(int[] arr, int first, int mid, int end, int[] tmp){
        int l = first;
        int r = mid+1;
        int k = 0;

        while (l <= mid && r <= end){
            if (arr[l] <= arr[r]){
                tmp[k] = arr[l];
                l++;
            } else {
                tmp[k] = arr[r];
                r++;
            }
            k++;
        }

        while (l<=mid){
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

    public static void main (String[]args){
        int[] arr = ArrayUtils.buildArray(50);
        ArrayUtils.printArray(arr);

//        bubbleSort(arr);
//        selectSort(arr);
        insertSort(arr);
        ArrayUtils.printArray(arr);
        mergeSort(arr);
        quickSort(arr);
        ArrayUtils.printArray(arr);
    }
}