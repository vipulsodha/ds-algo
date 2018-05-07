package hackerrank.strings.gemStones;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author sodha
 * https://www.hackerrank.com/challenges/gem-stones/problem
 */
public class Solution {

    static int gemstones(String[] arr){

        int count = 0;


        if (arr.length == 0) {
             return 0;
        }

        Map<Character, Boolean> gemCountMap = new HashMap<>();

        String first = arr[0];


        for (char c: first.toCharArray()) {

            gemCountMap.put(c, true);

        }



        for (int i = 1; i < arr.length; i++) {

            Map<Character, Boolean> innerGemCount = new HashMap<>();


            for (char c : arr[i].toCharArray()) {

                innerGemCount.put(c, true);
            }

            for (Map.Entry<Character , Boolean> e : gemCountMap.entrySet()) {

                if (!innerGemCount.containsKey(e.getKey())) {
                    gemCountMap.put(e.getKey(), false);
                }
            }

        }


        for (Map.Entry<Character , Boolean> e : gemCountMap.entrySet()) {

            if (e.getValue()) {
                count ++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}

