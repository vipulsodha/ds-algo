package maxSum;

import java.util.*;

public class Solution {

    static int[] maxSubarray(int[] arr) {
        // Complete this function




        int[] maxSubarray = arr.clone();

        int maxSubarrayValue = maxSubarray[0];

        int maxSubsequence = maxSubarray[0];
        for (int i = 1; i < arr.length; i ++) {

            if(maxSubsequence < 0) {

                if (arr[i] > 0) {
                    maxSubsequence = arr[i];
                } else {
                    if (maxSubsequence < arr[i]) {
                        maxSubsequence = arr[i];
                    }
                }

            } else if(maxSubsequence < maxSubsequence + arr[i]) {
                maxSubsequence += arr[i];
            }

            maxSubarray[i] = Math.max(maxSubarray[i], maxSubarray[i] + maxSubarray[i - 1]);

            if(maxSubarrayValue < maxSubarray[i]) {
                maxSubarrayValue = maxSubarray[i];
            }
        }

        return new int[] {maxSubarrayValue, maxSubsequence};
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
            int[] result = maxSubarray(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("");


        }
        in.close();
    }
}
