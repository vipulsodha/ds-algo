package hackerrank.strings.camecase;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author sodha
 * https://www.hackerrank.com/challenges/camelcase/problem
 */
public class Solution {

    static int camelcase(String s) {

        int count = s.length() > 0? 1 : 0;



        for (char c : s.toCharArray()) {

            if (Character.isUpperCase(c)) {
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}

