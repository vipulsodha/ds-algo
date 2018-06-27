package counterGame;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String counterGame(long n) {
        // Complete this function

        String binaryN = Long.toString(n, 2);

        int countOne = 0;
        int countZero = 0;

        for(char b : binaryN.toCharArray()) {

            if(b == '1') {
                countOne++;
            }
        }


        for(int i = binaryN.length() - 1; i > 0 ; i --) {

            if(binaryN.charAt(i) == '1') {
                break;
            } else {
                countZero ++;
            }
        }


        int finalCount = countOne + countZero;

        if(finalCount % 2 == 0) {

            return "Louise";
        } else {

            return "Richard";
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            String result = counterGame(n);
            System.out.println(result);
        }
        in.close();
    }
}
