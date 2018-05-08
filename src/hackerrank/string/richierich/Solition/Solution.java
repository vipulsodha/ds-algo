package hackerrank.string.richierich.Solition;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


/**
 * @author vipulsodha
 * https://www.hackerrank.com/challenges/richie-rich/problem
 */
public class Solution {


    /*
     * Complete the highestValuePalindrome function below.
     */
    static String highestValuePalindrome(String s, int n, int k) {
        /*
         * Write your code here.
         */

        if (s.length() == 1) {

            if (k > 0) {
                return "9";
            } else {
                return s;
            }

        }

        int changeCount = 0;

        int maxmizCount = 0;


        for (int i = 0, j = s.length() -1; i < s.length()&& j > 0;) {

            if(i>=j) {
                break;
            }

            if (s.charAt(i) != s.charAt(j)) {
                changeCount++;
            }

            i++;
            j--;

        }

        if (changeCount > k) {
            return "-1";
        } else if(changeCount < k) {
            maxmizCount = k - changeCount;
        }


        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0, j = s.length() -1; i < s.length()&& j > 0;) {

            if(i>j) {
                break;
            }

            if (s.charAt(i) == s.charAt(j)) {

                if (i==j && maxmizCount > 0 ) {

                    stringBuilder.setCharAt(i, '9');

                } else if (maxmizCount >=2 && s.charAt(i) != '9') {
                    stringBuilder.setCharAt(i, '9');
                    stringBuilder.setCharAt(j, '9');
                    maxmizCount= maxmizCount -2;
                }
            }

            if (s.charAt(i) != s.charAt(j)) {

                if (maxmizCount > 0 && s.charAt(i) != '9') {

                    stringBuilder.setCharAt(i, '9');
                    stringBuilder.setCharAt(j, '9');
                    maxmizCount--;
                } else {

                    if (Character.getNumericValue(s.charAt(i)) > Character.getNumericValue(s.charAt(j))) {
                        stringBuilder.setCharAt(j, s.charAt(i));
                    } else  {
                        stringBuilder.setCharAt(i, s.charAt(j));
                    }

                }

            }

            i++;
            j--;

        }

        return stringBuilder.toString();

    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scan.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        String s = scan.nextLine();

        String result = highestValuePalindrome(s, n, k);


        System.out.println(result);
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}

