package bigsorting;

import java.util.*;
import java.math.*;

public class Solution {

    static BigInteger[] bigSorting(BigInteger[] arr) {


        Arrays.sort(arr);

        return arr;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        BigInteger[] arr = new BigInteger[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = new BigInteger(in.next());
        }
        BigInteger[] result = bigSorting(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        System.out.println("");


        in.close();
    }
}
