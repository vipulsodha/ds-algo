package hackerrank.string.commonchild;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author vipulsodha
 * https://www.hackerrank.com/challenges/common-child/problem
 */
public class Solution {

    static int commonChild(String s1, String s2){
        // Complete this function



        int[][] subsequence = new int[s1.length() + 1][s2.length() + 1];



        for (int i = 1; i <= s1.length(); i++) {

            for (int j = 1; j <= s2.length(); j ++) {



                if (s1.charAt(i-1) == s2.charAt(j-1)) {

                    subsequence[i][j] = subsequence[i-1][j-1] + 1;

                } else {
                    subsequence[i][j] = Math.max(subsequence[i-1][j], subsequence[i][j-1]);
                }

            }

        }



        return subsequence[s1.length()][s2.length()];





    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}

