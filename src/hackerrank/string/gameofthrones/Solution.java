package hackerrank.string.gameofthrones;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author vipulsodha
 * https://www.hackerrank.com/challenges/game-of-thrones/problem
 */
public class Solution {

    static String gameOfThrones(String s){
        // Complete this function


        Map<Character, Integer> strMap = new HashMap<>();


        for (Character c : s.toCharArray()) {


            if (strMap.containsKey(c)) {
                strMap.put(c, strMap.get(c) + 1);
            } else {
                strMap.put(c, 1);

            }
        }

        int oddCount = 0;


        for (Map.Entry<Character, Integer> e : strMap.entrySet()) {


            if ((e.getValue() & 1) != 0) {

                oddCount++;
            }


        }



        return  oddCount > 1 ? "NO": "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}

