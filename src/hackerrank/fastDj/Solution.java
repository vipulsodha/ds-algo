package hackerrank.fastDj;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the shortestReach function below.
     */
    static Node[] shortestReach(int n, int m, int[][] edges, int s) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n+1, (Node s1, Node s2) -> s1.getDistance().compareTo(s2.getDistance()) );

        int[][] adjacencyMatrix = new int[n+1][n+1];

        List<Integer>[] adjacencyList = new List[n+1];


        for (int i = 0; i < m; i ++ ) {

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
        for (int i = 0; i <=n; i ++) {

            Node node = null;

            if(i == s) {
                node = new Node(i, 0);
            } else {
                node = new Node(i, Integer.MAX_VALUE);
            }

            distance[i] = node;
            minHeap.add(node);

        }

        boolean[] processedVertex = new boolean[n+1];

        while (minHeap.size() != 0) {

            Node node = minHeap.remove();

            int currentNodeIndex = node.getIndex();

            processedVertex[currentNodeIndex] = true;

            if(Objects.isNull(adjacencyList[currentNodeIndex])) {

                continue;
            }

            for(int i :  adjacencyList[currentNodeIndex]) {

                if(!processedVertex[i]){

                    int newDistance = node.getDistance() + adjacencyMatrix[currentNodeIndex][i];

                    if(node.getDistance() != Integer.MAX_VALUE && distance[i].getDistance() > newDistance) {

                        minHeap.remove(distance[i]);

                        distance[i].setDistance(newDistance);

                        minHeap.add(distance[i]);
                    }
                }
            }
        }

        return distance;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            int[][] edges = new int[m][3];

            for (int edgesRowItr = 0; edgesRowItr < m; edgesRowItr++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");

                for (int edgesColumnItr = 0; edgesColumnItr < 3; edgesColumnItr++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
                    edges[edgesRowItr][edgesColumnItr] = edgesItem;
                }
            }

            int s = Integer.parseInt(scanner.nextLine().trim());

            Node[] result = shortestReach(n, m, edges, s);

            for (int resultItr = 1; resultItr < result.length; resultItr++) {

                if(resultItr == s) {
                    continue;
                } else if(result[resultItr].getDistance() == Integer.MAX_VALUE) {
                    bufferedWriter.write(String.valueOf(-1));
                } else {
                    bufferedWriter.write(String.valueOf(result[resultItr].getDistance()));
                }


                if (resultItr != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();
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



