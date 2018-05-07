package optimalGame;

import java.util.Scanner;

public class Solution {



    public static int finxOptimal(int start, int end, int[] arr) {


        if (start > end || end < start) {
            return 0;
        }

        return Math.max(Math.min(finxOptimal(start + 2, end, arr), finxOptimal(start + 1, end-1, arr)) + arr[start],
                Math.min(finxOptimal(start, end - 2, arr), finxOptimal(start+1, end- 1, arr)) + arr[end]);

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];


        for (int i = 0; i < n; i ++) {
            arr[i] = in.nextInt();
        }


        System.out.println(finxOptimal(0, n -1, arr));
    }
}
