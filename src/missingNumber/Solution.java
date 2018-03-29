package missingNumber;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void missingNumbers(int[] arr, int[] brr) {


        int [] mapA = new int[100];

        int [] mapB = new int[100];


        int min = brr[0];

        for(int i =0 ; i < brr.length; i ++) {

            if(min > brr[i]) {
                min = brr[i];
            }

        }



        int [] missingNumbers = new int[100];

        for(int i =0 ; i < arr.length; i ++) {

            mapA[arr[i]- min] ++;

        }

        for(int i =0 ; i < brr.length; i ++) {



            mapB[brr[i]- min] ++;

        }

        for(int i =0 ; i < mapB.length; i ++) {

            if(mapB[i] != mapA[i]) {
                missingNumbers[i] = 1;
            }
        }

        for(int i =0 ; i < missingNumbers.length; i ++) {

            if(missingNumbers[i] == 1) {
                System.out.println(i + min);
            }

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        missingNumbers(arr, brr);

        System.out.println("");


        in.close();
    }
}
