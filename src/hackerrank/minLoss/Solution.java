package hackerrank.minLoss;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int minimumLoss(long[] price) {
        // Complete this function

        long minLoss = Integer.MIN_VALUE;

        int N = price.length;

        for(int i = 0; i < N-1; i++) {

            for (int j = i+1; j< N; j ++) {

                long loss = price[j] -  price[i] ;

                if(loss < 0 && loss > minLoss) {
                    minLoss = loss;
                }

            }

        }

        return (int)minLoss * -1;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
        }
        int result = minimumLoss(price);
        System.out.println(result);
        in.close();
    }
}
