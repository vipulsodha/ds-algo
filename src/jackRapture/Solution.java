package jackRapture;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static long findShortestFare(int[][] edges, int n) {


        PriorityQueue<Node> minHeap = new PriorityQueue<>(n+1, (Node s1, Node s2) -> s1.getDistance().compareTo(s2.getDistance()) );

        int[][] adjacencyMatrix = new int[n+1][n+1];

        List<Integer>[] adjacencyList = new List[n+1];

        for (int i = 0; i < edges.length; i++) {

            if(Objects.isNull(adjacencyList[edges[i][0]])) {

                adjacencyList[edges[i][0]] = new ArrayList<>();
            }

            if (Objects.isNull(adjacencyList[edges[i][1]])) {
                adjacencyList[edges[i][1]] = new ArrayList<>();
            }

            if(adjacencyMatrix[edges[i][0]][edges[i][1]] == 0) {

                adjacencyList[edges[i][0]].add(edges[i][1]);
                adjacencyList[edges[i][1]].add(edges[i][0]);
            }

            if(adjacencyMatrix[edges[i][0]][edges[i][1]] == 0 || adjacencyMatrix[edges[i][0]][edges[i][1]] > edges[i][2]) {

                adjacencyMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
                adjacencyMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }

        Node[] distance = new Node[n+1];

        for (int i = 1; i <=n; i ++) {

            Node node = null;

            if(i == 1) {
                node = new Node(i, 0);
            } else {
                node = new Node(i, Integer.MAX_VALUE);
            }

            distance[i] = node;
            minHeap.add(node);

        }

        boolean[] processedVertex = new boolean[n+1];

        while (minHeap.size() != 0) {

            if(processedVertex[n]) {
                break;
            }

            Node node = minHeap.remove();

            int currentNodeIndex = node.getIndex();

            processedVertex[currentNodeIndex] = true;

            if(Objects.isNull(adjacencyList[currentNodeIndex])) {

                continue;
            }

            for(int i :  adjacencyList[currentNodeIndex]) {

                if(adjacencyMatrix[currentNodeIndex][i] != 0) {

                    if(!processedVertex[i]){

                        int newDistance = adjacencyMatrix[currentNodeIndex][i] - node.getDistance();

                        if (newDistance < 0) {
                            newDistance = node.getDistance();
                        } else {
                            newDistance  = node.getDistance() + newDistance;
                        }

                        if(node.getDistance() != Integer.MAX_VALUE && distance[i].getDistance() > newDistance) {

                            minHeap.remove(distance[i]);

                            distance[i].setDistance(newDistance);

                            minHeap.add(distance[i]);

                        }
                    }
                }
            }
        }

        return distance[n].getDistance();
    }

    public static void main(String[] args) {
        String[] gNodesEdges = scanner.nextLine().split(" ");
        int gNodes = Integer.parseInt(gNodesEdges[0].trim());
        int gEdges = Integer.parseInt(gNodesEdges[1].trim());

        int [][] edges = new int[gEdges][3];

        for (int gItr = 0; gItr < gEdges; gItr++) {
            String[] gFromToWeight = scanner.nextLine().split(" ");
            int from = Integer.parseInt(gFromToWeight[0].trim());
            int to = Integer.parseInt(gFromToWeight[1].trim());
            int weight = Integer.parseInt(gFromToWeight[2].trim());

            edges[gItr][0] = from;
            edges[gItr][1] = to;
            edges[gItr][2] = weight;
        }


        long distance  = findShortestFare(edges, gNodes);
        System.out.println( distance == Integer.MAX_VALUE ? "NO PATH EXISTS" : distance);
    }
}

class Node {

    private Integer index;
    private  Integer distance;

    public Node(int index, int distance) {

        this.index = index;
        this.distance = distance;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}

