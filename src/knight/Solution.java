package knight;

/**
 * Created by vipulsodha on 01/05/18.
 * https://www.hackerrank.com/challenges/red-knights-shortest-path/problem
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static Integer addOrder = 1;


    static void updateDistance(int neighBourI, int neighBourJ,  Node node, Node[][] vertex, String[][] parents, boolean [][] processed, String parentPath, int parentInt, PriorityQueue<Node> priorityQueue, int n) {

        if(neighBourI >=0 && neighBourJ >= 0 && neighBourI < n && neighBourJ < n && !processed[neighBourI][neighBourJ]) {

            Node neighbourNode = null;

             if(Objects.isNull(vertex[neighBourI][neighBourJ])) {

                int newDistance = node.distance + 1;
                neighbourNode = new Node(neighBourI, neighBourJ, parentInt, newDistance, addOrder);
                neighbourNode.parent = node;
                addOrder++;
                vertex[neighBourI][neighBourJ] = neighbourNode;
                parents[neighBourI][neighBourJ] = parentPath;
                priorityQueue.add(neighbourNode);
            }
        }

    }


    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {

        boolean [][] processed = new boolean[n][n];

        Node [][] vertex = new Node[n][n];

        String[][] parents = new String[n][n];

        int [] neighbours = {1,2,3,4,5,6}; //{"UL", "UR", "R", "LR", "LL", "L"}

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(n, (Node s1, Node s2) -> {
            Integer r = s1.distance.compareTo(s2.distance);

            if (r == 0) {

                Integer s =  s1.position.compareTo(s2.position);

                return s.equals(0) ? s1.addOrder.compareTo(s2.addOrder) : s;

            } else {
                return r;
            }

        });

        Node start = new Node(i_start, j_start, 0, 0, 0);

        vertex[i_start][j_start] = start;

        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {

            Node node = priorityQueue.poll();

            if (node.i == i_end && node.j == j_end) {
                break;
            }

            processed[node.i][node.j] = true;

            int currentI = node.i;
            int currentJ = node.j;

            for (int l = 0; l < neighbours.length; l++) {

                int neighBourI;
                int neighBourJ;

                switch (neighbours[l]) {

                    case 1:

                         neighBourI = currentI - 2;
                         neighBourJ = currentJ - 1;

                        updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "UL", 1, priorityQueue, n);

                        break;

                    case 2:

                         neighBourI = currentI - 2;
                         neighBourJ = currentJ + 1;

                         updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "UR", 2, priorityQueue, n);

                        break;

                    case 3:

                        neighBourI = currentI;
                        neighBourJ = currentJ + 2;

                        updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "R", 3, priorityQueue, n);

                        break;

                    case 4:

                        neighBourI = currentI + 2;
                        neighBourJ = currentJ + 1;

                        updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "LR", 4, priorityQueue, n);

                        break;

                    case 5:

                        neighBourI = currentI + 2;
                        neighBourJ = currentJ - 1;

                        updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "LL", 5, priorityQueue, n);

                        break;

                    case 6:

                        neighBourI = currentI;
                        neighBourJ = currentJ - 2;

                        updateDistance(neighBourI, neighBourJ, node, vertex, parents, processed, "L", 6, priorityQueue, n);

                        break;
                }

            }

        }

        if (!Objects.isNull(vertex[i_end][j_end])) {

            Node destination = vertex[i_end][j_end];

            System.out.println(destination.distance);

            Stack<String> finalPath = new Stack<>();

            while (!Objects.isNull(destination) && !Objects.isNull(destination.parent)) {
                finalPath.push(parents[destination.i][destination.j]);
                destination = destination.parent;
            }

            while (!finalPath.isEmpty()) {

                System.out.print(finalPath.pop() + " ");
            }


        } else {
            System.out.println("Impossible");
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }
}


class Node {

    public Node(int i, int j, int position, int distance, int addOrder) {
        this.i = i;
        this.j = j;
        this.position = position;
        this.distance = distance;
        this.addOrder = addOrder;
    }

    Node parent;

    Integer i;
    Integer j;

    Integer position;

    Integer distance;

    Integer addOrder;

}
