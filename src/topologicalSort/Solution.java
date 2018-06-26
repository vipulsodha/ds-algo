package topologicalSort;

import java.util.Stack;

/**
 * Created by vipulsodha on 25/06/18.
 */
public class Solution {

    private static int[][] graph;

    private static Stack<Integer> stack =  new Stack<>();

    private static boolean[] visited ;
    private static void sort(int i) {


            visited[i] = true;

        for (int j = 0; j < 5; j++) {
            if (!visited[j]) {
                sort(j);
            }
        }

        stack.push(i);
    }

    private static void printSort() {

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static void addToGraph(int i, int j , int weight) {

        graph[i][j] = weight;

    }

    public static void main(String[] args) {

        graph = new int[5][5];
        visited = new boolean[5];

        addToGraph(0,1,1);
        addToGraph(0,2,1);
        addToGraph(0,4,2);
        addToGraph(1,2,2);
        addToGraph(1,3,5);
        addToGraph(2,3,3);
        addToGraph(2,4,5);
        sort(0);

        printSort();

    }

}
