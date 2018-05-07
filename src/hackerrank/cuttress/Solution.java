package hackerrank.cuttress;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author sodha
 * https://www.hackerrank.com/challenges/cut-the-tree/problem
 */
public class Solution {

    static int minimum = Integer.MAX_VALUE;

    static int totalCost = 0;

    static void updateCosts(Node node, int cost) {

        if (Objects.isNull(node)) {
            return;
        }

        node.childCost = node.childCost + cost;

        updateCosts(node.parent, cost);

    }

    static void findMin(Map<Integer, Node> map) {

        Set<Map.Entry<Integer, Node>> entrySet = map.entrySet();

        for (Map.Entry<Integer, Node> e : entrySet) {

            int cost = totalCost - (e.getValue().childCost + e.getValue().data);

            int treeCuttingCost = Math.abs(cost - (e.getValue().childCost + e.getValue().data));

            if (treeCuttingCost < minimum) {
                minimum = treeCuttingCost;
            }
        }

    }

    static int cutTheTree(int[] data, int[][] edges) {

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0 ; i < data.length; i ++) {

            Node node = new Node(data[i], i);
            totalCost = totalCost + data[i];
            map.put(i + 1, node);

        }

        for (int i = 0 ; i < data.length - 1; i ++) {
            Node node1 = map.get(edges[i][0]);
            Node node2 = map.get(edges[i][1]);

            if (node1.index == 0) {
                node1.childs.add(node2);
                node2.parent = node1;
            } else if(Objects.isNull(node1.parent)) {

            }


            updateCosts(node2.parent, node2.data);
        }

        findMin(map);

        return minimum;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for(int data_i = 0; data_i < n; data_i++){
            data[data_i] = in.nextInt();
        }
        int[][] edges = new int[n-1][2];
        for(int edges_i = 0; edges_i < n-1; edges_i++){

            edges[edges_i][0] = in.nextInt();
            edges[edges_i][1] = in.nextInt();


        }
        int result = cutTheTree(data, edges);
        System.out.println(result);
        in.close();
    }
}


class Node {

    public Node(int data, int index) {
        this.data = data;
        this.index = index;
    }

    int data;
    List<Node> childs = new ArrayList<>();

    Node parent;

    int childCost = 0;

    int index;
}