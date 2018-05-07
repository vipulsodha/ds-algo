package djktras;

import java.util.*;

public class Solution {

    static Node[] dj(int n, int m, int[][] edges, int s) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>(n+1, (Node s1, Node s2) -> s1.getDistance().compareTo(s2.getDistance()) );

        int[][] adjacencyMatrix = new int[n+1][n+1];

        for (int i = 0; i < m; i ++ ) {


            if(adjacencyMatrix[edges[i][0]][edges[i][1]] == 0 || adjacencyMatrix[edges[i][0]][edges[i][1]] > edges[i][2]) {

                adjacencyMatrix[edges[i][0]][edges[i][1]] = edges[i][2];
                adjacencyMatrix[edges[i][1]][edges[i][0]] = edges[i][2];
            }

        }

        System.out.println(Arrays.deepToString(adjacencyMatrix));

        Node[] distance = new Node[n+1];
        for (int i = 0; i <=n; i ++) {

            Node node = null;

            if(i == 1) {
                node = new Node(i, 0);
            } else {
                node = new Node(i, Integer.MAX_VALUE);
            }

            distance[i] = node;
//            mi  nHeap.add(node);

        }


        boolean[] processedVertex = new boolean[n+1];

        while (minHeap.size() != 0) {

            Node node = minHeap.poll();

            int currentNodeIndex = node.getIndex();

            processedVertex[currentNodeIndex] = true;

            for (int i = 1 ; i <=n; i ++) {

                if(adjacencyMatrix[currentNodeIndex][i] != 0) {

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
        }

        return distance;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < 3; j++){
                    edges[i][j] = in.nextInt();
                }
            }

            int s = in.nextInt();
            Node[] result = dj(n, m, edges, s);

            for (int i = 1; i < result.length; i++) {
                if(i == s) {
                    continue;
                }


                System.out.print(result[i].getDistance() == Integer.MAX_VALUE ? "-1 " : result[i].getDistance() + " ");
            }
            System.out.println("");

//            System.out.println(result.length);
        }
        in.close();
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

