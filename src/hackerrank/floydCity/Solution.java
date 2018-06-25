package hackerrank.floydCity;

/**
 * Created by vipulsodha on 24/06/18.
 * https://www.hackerrank.com/challenges/floyd-city-of-blinding-lights/problem
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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
        int roadNodes = Integer.parseInt(roadNodesEdges[0].trim());
        int roadEdges = Integer.parseInt(roadNodesEdges[1].trim());

        int[][] edgeWeights = new int[roadNodes + 1][roadNodes+ 1];

        for (int i = 0; i < roadEdges; i++) {
            String[] roadFromToWeight = scanner.nextLine().split(" ");

            edgeWeights[Integer.parseInt(roadFromToWeight[0].trim())][Integer.parseInt(roadFromToWeight[1].trim())] = Integer.parseInt(roadFromToWeight[2].trim());

        }

        calculateEdgeWeights(edgeWeights, roadNodes);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xy = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            if (x == y) {
                System.out.println(0);
            } else {
                System.out.println(edgeWeights[x][y] == Integer.MAX_VALUE ? "-1" : edgeWeights[x][y]);
            }
        }

        scanner.close();
    }
}


