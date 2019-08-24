package com.learning.algorithms.sort;

public class MinKNumbers {

    public static int[] getMinKNumbers(int[] arr, int k){
        if (k < 1 || k > arr.length)
            return arr;
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++){
            insertHeap(kHeap, arr[i], i);
        }

        for (int i = k; i < arr.length; i++){
            if (arr[i] < kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    // 构建大顶堆
    private static void insertHeap(int[] heapArr, int value, int index){
        heapArr[index] = value;
        while (index != 0){
            int parent = (index - 1) / 2;
            if (heapArr[parent] < heapArr[index]){
                swap(heapArr, parent, index);
                index = parent; //更新，以向上直到达到堆顶
            } else {
                break;
            }
        }
    }

    // 堆的调整
    private static void heapify(int[] heapArr, int index, int heapSize){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxIndex = index;
        while (left < heapSize){
            if (heapArr[left] > heapArr[index]){
                maxIndex = left;
            }
            if (right < heapSize && heapArr[right] > heapArr[maxIndex]){
                maxIndex = right;
            }

            if (maxIndex != index){
                swap(heapArr, index, maxIndex);
            } else {
                break;
            }

            index = maxIndex;
            left = maxIndex * 2 + 1;
            right = maxIndex * 2 + 2;
        }
    }

    private static void swap(int[] arr, int indexA, int indexB){
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.buildArray(50);
        ArrayUtils.printArray(arr);

        int[] kMinArr = getMinKNumbers(arr, 7);
        ArrayUtils.printArray(kMinArr);

    }
}
