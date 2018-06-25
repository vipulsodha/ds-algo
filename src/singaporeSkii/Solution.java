package singaporeSkii;

import java.util.Scanner;

/**
 * Created by vipulsodha on 24/06/18.
 * http://geeks.redmart.com/2015/01/07/skiing-in-singapore-a-coding-diversion/
 */
public class Solution {



    private static void  calculateEdgeWeights(int[][] edgeWeights, int n) {


        for (int i = 1; i <=n ; i++) {

            for (int j = 0; j <=n ; j++) {


                if (edgeWeights[i][j] == 0 && i!=j) {

                    edgeWeights[i][j] = Integer.MAX_VALUE;

                }

            }

        }

        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <=n ; j++) {

                    if(edgeWeights[i][k] == Integer.MAX_VALUE ||  edgeWeights[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }

                    if (edgeWeights[i][j] > edgeWeights[i][k] + edgeWeights[k][j]) {
                        edgeWeights[i][j] = edgeWeights[i][k] + edgeWeights[k][j];
                    }
                }
            }
        }

    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] roadNodesEdges = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(roadNodesEdges[0].trim());
        int columns = Integer.parseInt(roadNodesEdges[1].trim());

        int[][] edgeWeights = new int[rows][columns];


        for (int i = 0; i < rows; i++) {
//            int[] roadNodesEdges = scanner.nextLine().split(" ");

        }



        calculateEdgeWeights(edgeWeights, 1);

        System.out.println("hello");

        scanner.close();
    }
}


