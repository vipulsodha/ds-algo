package hackerrank.pairs;

/**
 * Created by vipulsodha on 01/05/18.
 * https://www.hackerrank.com/challenges/pairs/problem
 */
import java.util.*;

public class Solution {

    static int pairs(int k, int[] arr) {
        // Complete this function

        int matchCount = 0;


        Arrays.sort(arr);


        for (int i = 0, j = 1;  i < arr.length && j < arr.length;) {

            if (arr[j] - arr[i] < k) {
                j++;
            }  else if(arr[j] - arr[i] > k) {

                i++;

            } else {

                matchCount++;
                i++;
                j++;
            }

        }


        return matchCount;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = pairs(k, arr);
        System.out.println(result);
        in.close();
    }
}
