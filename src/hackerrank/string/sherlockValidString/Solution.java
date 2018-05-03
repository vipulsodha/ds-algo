package hackerrank.string.sherlockValidString;



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author sodha
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
public class Solution {

    static String isValid(String s) {

        if (s.length() ==0) {
            return  "YES";
        }

        Map<Character, Integer> stringCountMap = new HashMap<>();

        int max = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;

        int minCount = 0;

        int maxCount = 0;

        for (char c: s.toCharArray()) {
            if (stringCountMap.containsKey(c)) {
                stringCountMap.put(c, stringCountMap.get(c) + 1 );
            } else {
                stringCountMap.put(c,1);
            }
        }

        boolean isValid = true;

        for (Map.Entry<Character, Integer> e : stringCountMap.entrySet()) {

            if (e.getValue() < min ) {
                min = e.getValue();
            }

            if (e.getValue() > max) {
                max = e.getValue();
            }

        }

        for (Map.Entry<Character, Integer> e : stringCountMap.entrySet()) {

            if (e.getValue() == min ) {
                minCount ++;
            } else if (e.getValue() == max) {
                maxCount ++;
            }

            if (max > e.getValue() && e.getValue() > min) {
                isValid = false;
            }

        }

        if (isValid) {

            if (max != min) {

                if (Math.abs(max - min) > 1) {
                    isValid = false;
                } else {

                    if (maxCount > minCount && minCount > 1) {

                        isValid = false;
                    } else if (minCount > maxCount && maxCount > 1) {
                        isValid = false;
                    } else if (maxCount == minCount && maxCount > 1){
                        isValid = false;
                    }

                }
            }
        }


        return isValid ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}

