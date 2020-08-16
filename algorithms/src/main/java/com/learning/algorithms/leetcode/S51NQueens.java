package com.learning.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题
 * @author qdj
 * @date 2020/8/15 15:03
 */
public class S51NQueens {
    public static class Point {
        public int x;
        public int y;
        public Point(int x, int y){ this.x = x; this.y = y; }
    }
    public static boolean isValid(Point point, List<Point> pointList){
        if (point.x * point.y < 0)
            return false;
        for (Point p: pointList) {
            if (point.x == p.x || point.y == p.y || (point.y - point.x) == (p.y - p.x) || (point.y + point.x ) == (p.y + p.x)){
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> solveNQueens(int n) {
        List<Point> pointList = new LinkedList<Point>();
        List<List<String>> ret = new LinkedList<List<String>>();
        int[] startArr = new int[n];
        for (int i = 0; i < n;i++)  startArr[i] = -1;

        for (int i = 0; i < n; i++){
            for (int j = startArr[i] + 1; j < n; j++ ){
                Point currentPoint = new Point(i, j);
                if (isValid(currentPoint, pointList)){
                    pointList.add(currentPoint);
                    startArr[i] = j;
                    break;
                }
            }
            // back
            if (pointList.size() != i + 1){
                if (pointList.size() == 0){
                    //all done.
                    break;
                } else {
                    pointList.remove(pointList.size() - 1);
                    startArr[i] = -1;
                    i-=2 ;
                    continue;
                }
            }
            // log
            if (i == n - 1){
                List<String> way = new ArrayList<String>();
                for (int p = 0; p < pointList.size(); p++){
                    char[] level = new char[n];
                    for (int q = 0; q < n; q++) level[q] = '.';
                    level[pointList.get(p).y] = 'Q';
                    way.add(new String(level));
                    System.out.println(new String(level));
                }
                System.out.println("===========");
                ret.add(way);
                pointList.remove(pointList.size() - 1);
                i--;
                System.out.println(ret.size());
            }
        }
        System.out.println(ret.size());
        return ret;
    }

    public static void markBoard(int i, int j, int[][] board, int len, int factor){
        for (int x = 0; x < len; x++){
            for (int y = 0; y < len; y++){
                if (x == i || y == j || (x+y) == (i+j) || (y-x) == (j-i)){
                    board[x][y] += factor;
                }
            }
        }
        board[i][j] = 0;
    }

    public static List<String> getSolution(int[][] board, char[][] solution, int len){
        List<String> s = new ArrayList<String>();
        for (int x = 0; x < len; x++) {
            for (int y = 0; y < len; y++) {
                if (board[x][y] == 0){
                    solution[x][y] = 'Q';
                } else {
                    solution[x][y] = '.';
                }
            }
            s.add(new String(solution[x]));
        }
        return s;
    }

    public static List<List<String>> solveNQueens2(int n) {
        List<List<String>> ret = new LinkedList<List<String>>();
        // 可放为0 每与一个Queen冲突，则+1
        int[][] board = new int[n][n];
        char[][] solution = new char[n][n];
        int[] startArr = new int[n];
        for (int i = 0; i < n;i++)  startArr[i] = -1;

        for (int i = 0; i < n; i++){
            int before = startArr[i];
            for (int j = startArr[i] + 1; j < n; j++ ){
                if (board[i][j] == 0){
                    markBoard(i, j, board, n,1);
                    startArr[i] = j;
                    break;
                }
            }
            // back
            if (startArr[i] == before){
                if (i != 0){
                    markBoard(i - 1, startArr[i - 1], board, n, -1);
                    startArr[i] = -1;
                    i = i - 2;
                    continue;
                } else if (startArr[i] == n - 1){
                    break;
                }
            }
            // log
            if (i == n - 1 && startArr[i] != -1){
                ret.add(getSolution(board, solution, n));
                markBoard(i, startArr[i], board, n, -1);
                i--;
            }
        }
        System.out.println(ret.size());
        return ret;
    }
    public static void main(String[] args) {
        solveNQueens2(2);
    }
}
