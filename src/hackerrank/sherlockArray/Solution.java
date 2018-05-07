package hackerrank.sherlockArray;

/**
 * Created by vipulsodha on 01/05/18.
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a){
        // Complete this function

        if(a.length == 1) {
            return "YES";
        }

        int allSum = 0;


        boolean isSherlockArray = false;

        for (int i = 0; i < a.length; i++) {
            allSum = allSum + a[i];
        }


        int currentSum = 0;
        for (int i = 0; i < a.length - 2; i++) {

            currentSum = currentSum + a[i];

            if (currentSum == (allSum - a[i+1] - currentSum)) {
                isSherlockArray = true;

                break;
            }


        }

        return isSherlockArray ? "YES" : "NO";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}
