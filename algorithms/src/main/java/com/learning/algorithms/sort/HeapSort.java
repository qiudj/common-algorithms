package com.learning.algorithms.sort;

/**
 * 堆排序的实现：
 * 1.堆的调整
 * 2.交换
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if (arr == null || arr.length == 0)    return;
        int len = arr.length;

        while (len > 0 ) {
            //调整过程
            int lastNotLeafIndex = len / 2 - 1;
            while (lastNotLeafIndex >= 0) {
                adjustHeap(arr, lastNotLeafIndex, len);
                lastNotLeafIndex--;
            }
            // 交换过程
            ArrayUtils.swap(arr, 0, len - 1);
            len--;
        }
    }

    /**
     * 考虑完全二叉树的特点，最后一个结点的父节点肯定有左子树，所以边界判断的时候，
     * 用left是合理的。
     * @param arr 堆数组
     * @param index 要调整的位置
     * @param heapSize 用于标识堆的范围
     */
    private static void adjustHeap(int[] arr, int index, int heapSize){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxOfLeftAndRight = index;

        while (left < heapSize) {
            if (arr[index] < arr[left]){
                maxOfLeftAndRight = left;
            }

            if (right < heapSize && arr[maxOfLeftAndRight] < arr[right]){
                maxOfLeftAndRight = right;
            }

            if (maxOfLeftAndRight != index){
                ArrayUtils.swap(arr, index, maxOfLeftAndRight);
            } else {
                break;
            }

            index = maxOfLeftAndRight;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public static void main(String[] args) {
        // int[] arr = new int[]{2,3,1,4,5};
        int[] arr = ArrayUtils.buildArray(100);
        ArrayUtils.printArray(arr);
        heapSort(arr);
        ArrayUtils.printArray(arr);
    }
}
