package com.learning.algorithms.search;

import com.learning.algorithms.sort.ArrayUtils;

/**
 * 二分查找的几个问题：
 */
public class BinarySearch {
    //返回key在有序数组中出现的位置
    public static int findValueIndex(int[] arr, int value){
        if (arr == null)
            return -1;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] == value){
                return mid;
            } else if (arr[mid] > value){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    //查找第一个与value相等的元素,元素有重复
    public static int findValueFirstIndex(int[] arr, int value){
        if (arr == null){
            return -1;
        }
        if (arr[0] == value)
            return 0;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = (l + r)  >> 1;
            if (arr[mid] > value){
                r = mid - 1;
            } else if (arr[mid] < value){
                l = mid + 1;
            } else {
                if (mid - 1 >= 0 && arr[mid - 1] != value){
                    return mid;
                }
                r = mid - 1;
                // 也可以局部向前的方法，
                // 但是在重复数据多情况下显然是没有二分查找快的
/*              int pos = mid;
                while (pos >= 0 && arr[pos] == value){
                    pos--;
                }
                return pos++;*/
            }
        }
        return -1;
    }

    // 查找最后面一个与value相等元素
    public static int findValueLastIndex(int[] arr, int value){
        if (arr == null || arr.length == 0){
            return -1;
        }
        if (arr[arr.length - 1] == value){
            return arr.length - 1;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] < value){
                l = mid + 1;
            } else if (arr[mid] > value){
                r = mid - 1;
            } else {
                if (mid + 1 < arr.length && arr[mid + 1] != value){
                    return mid;
                }
                l = mid + 1;
            }
        }
        return -1;

    }

    /* 查找最后一个小于value的元素,返回其数组下标*/
    public static int findLastElementSmallerThanValue(int[] arr, int value){
        if (arr == null || arr.length == 0 || arr[0] >= value) return -1;
        if (arr[arr.length - 1] < value)    return arr.length - 1;
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] < value){
                if (mid + 1 == arr.length || (mid + 1 < arr.length && arr[mid + 1] >= value)){
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    /* 查找最后一个小于等于value的元素下标*/
    public static int findLastElementSmallerThanOrEqualValue(int[] arr, int value){
        if (arr == null || arr.length == 0 || arr[0] > value)   return -1;
        if (arr[arr.length - 1] <= value)   return arr.length - 1;
        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] <= value){
                if (mid + 1 == arr.length || (mid + 1 < arr.length && arr[mid + 1] > value)){
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int findFirstElementLargerThanValue(int[] arr, int value){
        if (arr == null || arr.length == 0 || arr[arr.length - 1] <= value)  return -1;
        if (arr[0] > value ) return 0;

        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] > value){
                if (mid == 0 || (mid - 1 > 0 && arr[mid - 1] <= value)){
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int findFisrtElementLagerThanOrEqualValue(int[] arr, int value){
        if (arr == null || arr.length == 0 || arr[arr.length - 1] < value)  return -1;
        if (arr[0] >= value) return 0;

        int l = 0, r = arr.length - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (arr[mid] >= value){
                if (mid - 1 == 0 || (mid - 1 > 0 && arr[mid - 1] < value)){
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 300; i++){
            int[] arr2 = ArrayUtils.buildOrderedDuplicatedArray(50);
            ArrayUtils.printArray(arr2);
            System.out.println("最后一个<5的位置：  " + findLastElementSmallerThanValue(arr2, 5));
            System.out.println("最后一个<=5的位置： " + findLastElementSmallerThanOrEqualValue(arr2, 5));
            System.out.println("第一个>5的位置：    " + findFirstElementLargerThanValue(arr2, 5));
            System.out.println("第一个>=5的位置:    " + findFisrtElementLagerThanOrEqualValue(arr2, 5));
            System.out.println();
        }

    }
}
