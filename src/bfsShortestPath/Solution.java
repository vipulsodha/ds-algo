package bfsShortestPath;



import java.util.*;
public class Solution {

    static int[] bfs(int n, int m, int[][] edges, int s) {
        // Complete this function

        int[][] adjacencyMatrix = new int[n+1][n+1];

        for (int i = 0; i < m; i ++ ) {

            adjacencyMatrix[edges[i][0]][edges[i][1]] = 6;
            adjacencyMatrix[edges[i][1]][edges[i][0]] = 6;
        }

        int[] distance = new int[n+1];
        for (int i = 0; i <=n; i ++) {

            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;

        LinkedList<Integer> nextLevelNodes = new LinkedList<>();

        nextLevelNodes.add(s);

        while (nextLevelNodes.size() != 0) {

            int node = nextLevelNodes.poll();

            for (int i = 1 ; i <=n; i ++) {

                if(adjacencyMatrix[node][i] == 6) {

                    if(distance[i] == Integer.MAX_VALUE) {
                        nextLevelNodes.add(i);

                        if(distance[i] > distance[node] + 6 ) {

                            distance[i] = distance[node] + 6;
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
            int[][] edges = new int[m][2];
            for(int edges_i = 0; edges_i < m; edges_i++){
                for(int edges_j = 0; edges_j < 2; edges_j++){
                    edges[edges_i][edges_j] = in.nextInt();
                }
            }

            int s = in.nextInt();
            int[] result = bfs(n, m, edges, s);



            for (int i = 1; i < result.length; i++) {
                if(i == s) {
                    continue;
                }

                System.out.print(result[i] == Integer.MAX_VALUE ? "-1 " : result[i] + " ");
            }
            System.out.println("");

            System.out.println(result.length);


        }
        in.close();
    }
}

