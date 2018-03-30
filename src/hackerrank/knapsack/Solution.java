package hackerrank.knapsack;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int unboundedKnapsack(int k, int[] arr) {
        // Complete this function

        int[][] dp = new int[arr.length + 1][k+1];


        for (int i = 1; i <=arr.length; i++) {

            for (int j = 1; j <=k; j++) {

                int weight = arr[i-1];

                if(j >=weight) {
                    int temp = Math.max(dp[i][j-weight] + weight, dp[i-1][j]);

                    if (temp > j) {
                        dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    } else {
                        dp[i][j] = temp;
                    }

                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[arr.length][k];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int j = 0; j < t; j++) {

            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];

            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int result = unboundedKnapsack(k, arr);
            System.out.println(result);
        }


        in.close();
    }
}
