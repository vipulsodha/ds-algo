package hackerrank.string.isPalindrome;




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * @author vipulsodha
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 */
public class Solution {





    static boolean isPalindrome(String s) {


        for (int i = 0, j = s.length() -1; i < s.length() && j > 0;) {

            if (i == j) {
                break;
            }

            if (s.charAt(i) != s.charAt(j)) {

                return false;

            }

            i++;
            j--;

        }

        return true;
    }

    static int palindromeIndex(String s) {

        for (int i = 0, j = s.length() -1; i < s.length() && j > 0;) {


            if (i == j) {
                 break;
            }

            if (s.charAt(i) != s.charAt(j)) {

                boolean plusI = isPalindrome(new StringBuilder(s).deleteCharAt(i).toString());
                boolean minusJ = isPalindrome(new StringBuilder(s).deleteCharAt(j).toString());

                if (plusI) {
                    return i;
                } else if (minusJ) {
                    return j;
                }

            }

            i++;
            j--;

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
}

