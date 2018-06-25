package hackerrank.array;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/**
 * @author sodha
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class Solution {

    /*
     * Complete the arrayManipulation function below.
     */
    static int arrayManipulation(int n, int[][] queries) {
        /*
         * Write your code here.
         */

        int[] array = new int[n + 1];

        Map<String, String> map;



         for (int[] ar : queries) {


                int a = ar[0];
                int b = ar[1];
                int k = ar[2];

                array[a-1] = array[a-1] +k;
                array[b] =  array[b] - k;

         }

         int max = 0;
         int sum = 0;


         for (int i = 1; i < n; i ++) {

             sum = sum + array[i];

             if (max < sum) {
                 max = sum;
             }
         }

         return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] queries = new int[m][3];

        for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int result = arrayManipulation(n, queries);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println(result);
    }
}

