package hackerrank.string.makingAnagram;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author sodha
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class Solution {

    static int makingAnagrams(String s1, String s2){
        // Complete this function



        int count = 0;



        Map<Character, Integer> str1Map = new HashMap<>();
        Map<Character, Integer> str2Map = new HashMap<>();


        for (int i = 0; i < s1.length(); i ++) {

            char char1 = s1.charAt(i);

            if (str1Map.containsKey(char1)) {
                str1Map.put(char1, str1Map.get(char1) + 1);
            } else {
                str1Map.put(char1, 1);
            }

        }

        for (int i = 0; i < s2.length(); i ++) {
            char char2 = s2.charAt(i);
            if (str2Map.containsKey(char2)) {
                str2Map.put(char2, str2Map.get(char2) + 1);
            } else {
                str2Map.put(char2, 1);
            }

        }


        for (Map.Entry<Character, Integer> e: str1Map.entrySet()) {

            if (str2Map.containsKey(e.getKey())) {


                count = count + Math.abs(e.getValue() - str2Map.get(e.getKey()));
            } else  {

                count = count + e.getValue();
            }

        }


        for (Map.Entry<Character, Integer> e: str2Map.entrySet()) {

            if (!str1Map.containsKey(e.getKey())) {


                count = count + e.getValue();
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}

