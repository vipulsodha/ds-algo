package hackerrank.eventree;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/even-tree/problem
 */
public class Solution {

    private static int[][] graph;

    private static boolean[] visited;

    private static final Scanner scanner = new Scanner(System.in);

    private static int count = 0;

    private static int dfs(int i, int n) {

        int oddChildCount = 0;

        visited[i] = true;

        for (int j = 0; j < n; j++) {

            if (!visited[j] && graph[i][j] == 1) {
                int result = dfs(j, n);

                if ((result & 1) == 0) {

                    count ++;

                } else {

                    oddChildCount += result;

                }
            }
        }

        return oddChildCount + 1;
    }



    public static void main(String[] args) {
        String[] treeNodesEdges = scanner.nextLine().split(" ");
        int treeNodes = Integer.parseInt(treeNodesEdges[0].trim());
        int treeEdges = Integer.parseInt(treeNodesEdges[1].trim());

        graph = new int[treeNodes][treeNodes];
        visited = new boolean[treeNodes];

        for (int i = 0; i < treeEdges; i++) {
            String[] treeFromTo = scanner.nextLine().split(" ");
            graph[Integer.parseInt(treeFromTo[1].trim()) - 1][Integer.parseInt(treeFromTo[0].trim()) - 1] = 1;
        }

        dfs(0, treeNodes);

        // Write your code here.

        System.out.println(count);

        scanner.close();
    }
}
