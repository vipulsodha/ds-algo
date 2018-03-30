package hackerrank.coinChange;

/**
 * Created by vipulsodha on 24/03/18.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long getWays(int n, int[] c){


        Arrays.sort(c);

        int [][] values = new int[c.length][n + 1];

//        System.out.println(Arrays.toString(c));



        for (int i = 0; i < c.length; i++) {

            for (int j = 0; j <= n; j++) {

                if (j == 0) {
                    values[i][j] = 1;
                }

                else if(c[i] <= j) {
                    if(i == 0) {
                        values[i][j] = values[i][j-c[i]];
                    } else {
                        values[i][j] = values[i][j-c[i]] + values[i-1][j];
                    }
                } else {
                    if(i==0) {
                        values[i][j] = 0;
                    } else {
                        values[i][j] = values[i-1][j];
                    }
                }

            }
        }

//        System.out.println(Arrays.deepToString(values));


        return values[c.length - 1][n];
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);

        System.out.println(ways);
    }
}

