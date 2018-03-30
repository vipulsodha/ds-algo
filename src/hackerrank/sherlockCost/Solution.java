package hackerrank.sherlockCost;


import java.util.*;


public class Solution {

    static long cost(int[] arr) {
        // Complete this function


        int[][] dp = new int[arr.length][2];

        for (int i =1 ; i < dp.length; i ++) {


            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + Math.abs(1 - arr[i-1]));
            dp[i][1] = Math.max(dp[i-1][0] + arr[i] - 1, dp[i-1][1] + Math.abs(arr[i] - arr[i-1]));

        }

       return Math.max(dp[arr.length-1][0], dp[arr.length-1][1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = cost(arr);
            System.out.println(result);
        }
        in.close();
    }
}

