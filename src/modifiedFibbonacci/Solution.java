package modifiedFibbonacci;


import java.util.*;
import java.math.*;

public class Solution {

    static BigInteger fibonacciModified(int t1, int t2, int n) {
        // Complete this function


        BigInteger T1 = BigInteger.valueOf(t1);
        BigInteger T2 = BigInteger.valueOf(t2);

        BigInteger temp = BigInteger.valueOf(0);

        for (int i = 2; i < n; i++) {
            temp = T1.add(T2.pow(2));
            T1 =T2;
            T2 = temp;
        }


        return T2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();
        BigInteger result = fibonacciModified(t1, t2, n);
        System.out.println(result);
        in.close();
    }
}
