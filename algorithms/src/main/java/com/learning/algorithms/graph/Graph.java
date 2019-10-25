package com.learning.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 图的两种遍历方式：BFS和DFS。
 * 图的表示方式有：邻接数组(矩阵)，以及邻接表；
 * 这里使用了邻接矩阵的表示形式。
 * @author qdj
 **/
public class Graph {
    private static final int MAX_VERTEX = 20;
    private final Vertex[] vertices;
    private int[][] adjacentMatrix;
    private int vertexCount;

    class Vertex {
        public boolean visited;
        public String val;
        public Vertex(String val){
            this.val = val;
            this.visited = false;
        }
    }

    public Graph(){
        this.vertices = new Vertex[MAX_VERTEX];
        this.adjacentMatrix = new int[MAX_VERTEX][MAX_VERTEX];
        this.vertexCount = 0;
    }

    public void showVertex(final int vertexIndex){
        System.out.println(this.vertices[vertexIndex].val);
    }

    public void addVertex(final String val){
        this.vertices[this.vertexCount++] = new Vertex(val);
    }

    public void addEdge(final int startVertexIndex,
                        final int endVertexIndex,
                        final int weight,
                        final boolean directed){
        if (startVertexIndex >= 0 && startVertexIndex < vertexCount &&
                endVertexIndex >= 0 && endVertexIndex < vertexCount){
            this.adjacentMatrix[startVertexIndex][endVertexIndex] = weight;
            if (!directed){
                this.adjacentMatrix[endVertexIndex][startVertexIndex] = weight;
            }
        }
    }

    public void addEdge(final int startVertexIndex, final int endVertexIndex){
        this.addEdge(startVertexIndex, endVertexIndex, 1, false);
    }

    public int getUnvisitedAdjacentVertexIndex(final int vertexIndex){
        for (int i = 0; i < this.vertexCount; i++){
            if (this.adjacentMatrix[vertexIndex][i] != 0 && !this.vertices[i].visited){
                return i;
            }
        }
        return -1;
    }

    private void resetAllVertexNotVisit(){
        for (int i = 0; i < vertexCount; i++){
            this.vertices[i].visited = false;
        }
    }

    public void dfs(){
        final Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        showVertex(0);
        this.vertices[0].visited = true;
        while (!stack.isEmpty()){
           final int adjacentVertexIndex = getUnvisitedAdjacentVertexIndex(stack.peek());
           if (adjacentVertexIndex == -1){
               stack.pop();
           } else {
               showVertex(adjacentVertexIndex);
               vertices[adjacentVertexIndex].visited = true;
               stack.push(adjacentVertexIndex);
           }
        }
        resetAllVertexNotVisit();
    }

    public void bfs(){
        final Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        this.vertices[0].visited = true;
        showVertex(0);
        while (!queue.isEmpty()){
            final int vertexIndex = queue.remove();
            int adjacentIndex;
            while ((adjacentIndex = getUnvisitedAdjacentVertexIndex(vertexIndex)) != -1){
                showVertex(adjacentIndex);
                this.vertices[adjacentIndex].visited = true;
                queue.add(adjacentIndex);
            }
        }
        resetAllVertexNotVisit();
    }

    /**
     * 构建图并返回
     * 无向图如下：
     * A  -------  B --- C
     * |           |   /
     * |           |  /
     * |           | /
     * |           |/
     * D  -------  E
     *
     * 其邻接矩阵：
     * -----------------------
     * | *  0A  1B  2C  3D  4E
     * |0A      1       1
     * |1B  1       1       1
     * |2C      1           1
     * |3D  1               1
     * |4E      1   1   1
     * -----------------------
     */
    public static Graph buildGraph(){
        final Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(2,4);
        graph.addEdge(3,4);

        return graph;
    }

    public static void main(String[] args) {
        Graph graph = Graph.buildGraph();
        System.out.println("DFS...");
        graph.dfs();
        System.out.println("BFS...");
        graph.bfs();
    }
}