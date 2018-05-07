package hackerrank.string.anagram;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author vipulsodha
 * https://www.hackerrank.com/challenges/anagram/problem
 */
public class Solution {

    static int anagram(String s) {


        int n = s.length();


        if(n%2 != 0) {
            return -1;
        }

        int mid = s.length() /2;


        Map<Character, Integer> str1Map = new HashMap<>();
        Map<Character, Integer> str2Map = new HashMap<>();


        for (int i = 0; i < mid; i ++) {

            char char1 = s.charAt(i);
            char char2 = s.charAt(mid + i);


            if (str1Map.containsKey(char1)) {
                str1Map.put(char1, str1Map.get(char1) + 1);
            } else {
                str1Map.put(char1, 1);
            }

            if (str2Map.containsKey(char2)) {
                str2Map.put(char2, str2Map.get(char2) + 1);
            } else {
                str2Map.put(char2, 1);
            }

        }


        int count = 0;

        for (Map.Entry<Character, Integer> e : str1Map.entrySet()) {


           if (!str2Map.containsKey(e.getKey())) {

               count = count + e.getValue();
           } else {

               if (e.getValue() > str2Map.get(e.getKey())) {

                   count = count + (e.getValue() - str2Map.get(e.getKey()));
               }
           }


        }




        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
