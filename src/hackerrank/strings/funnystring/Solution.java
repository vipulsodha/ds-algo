package hackerrank.strings.funnystring;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author sodha
 * https://www.hackerrank.com/challenges/funny-string/problem
 */
public class Solution {

    static String funnyString(String s){

        boolean finalResult = true;

        int i =0,j = s.length() - 1;;
        while (i < s.length() - 1 && j > 0) {

            if (Math.abs((int)s.charAt(i + 1) - (int)s.charAt(i)) !=  Math.abs((int)s.charAt(j) - (int)s.charAt(j -1))) {
                finalResult = false;
                break;
            }

            i++;
            j--;

        }

        return finalResult ? "Funny" : "Not Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            System.out.println(funnyString(s));
        }
    }
}

