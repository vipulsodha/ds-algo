package hackerrank.strings.reducedStrings;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author sodha
 * https://www.hackerrank.com/challenges/reduced-string/problem
 */
public class Solution {

    static String super_reduced_string(String s){
        // Complete this function

        StringBuilder builder = new StringBuilder(s);

        for (int i = 1; i < builder.length();) {

            if (builder.charAt(i) == builder.charAt(i -1)) {

                builder.deleteCharAt(i);
                builder.deleteCharAt(i-1);

                i = 1;
            } else {
                i++;
            }

        }

        return builder.length() > 0 ? builder.toString() : "Empty String";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
