package com.learning.algorithms.leetcode;

public class O5 {
    // "%20"
    public String replaceSpace(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length;i++){
            if (arr[i] == ' '){
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
