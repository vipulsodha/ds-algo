package hackerrank.brackets;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {
        // Complete this function


        Stack<Character> brackets = new Stack<Character>();


        boolean isBalanced = true;


        for(char c : s.toCharArray()) {

            if(c == '[' || c == '{' || c == '(') {

                brackets.push(c);
            } else {

                if(brackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char bracket = brackets.pop();


                if(c == '}' && bracket != '{') {

                    isBalanced = false;
                    break;
                }


                if(c == ']' && bracket != '[') {

                    isBalanced = false;
                    break;
                }


                if(c == ')' && bracket != '(') {

                    isBalanced = false;
                    break;
                }

            }

        }

        return isBalanced ? "YES" : "NO";



    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
