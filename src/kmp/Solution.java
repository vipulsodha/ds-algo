package kmp;

import java.util.Arrays;

/**
 * Created by vipulsodha on 21/04/18.
 */
public class Solution {




    public static int findSubString(String pattern, String string, int[] lsp) {

        char[] patternArray = pattern.toCharArray();
        char[] stringArray = string.toCharArray();


        int index = 0;
        int matchStart = -1;
        for (int i =0; i < string.length();) {

            if(index >= patternArray.length) {
                break;
            }



            if (patternArray[index] == stringArray[i]) {



                if(index == patternArray.length -1) {
                    matchStart = i - index;
                    break;
                }

                i++;
                index++;


            } else {

                if(index !=0) {
                    index = lsp[index-1];
                } else {
                    i++;
                }


            }
        }

        return matchStart;
    }



    public static int[] buildLsp(String pattern){


        int[] lsp = new int[pattern.length()];

        char[] patternArray = pattern.toCharArray();


        int index = 0;
        lsp[0] = 0;
        for (int i = 1; i < pattern.length();) {

            if (patternArray[i] == patternArray[index]) {
                lsp[i] = index+1;
                index++;
                i++;
            } else {
                if(index!=0) {

                    index = lsp[index-1];

                } else {
                    lsp[i] =0;
                    i++;
                }

            }
        }



        return lsp;
    }




    public static void main(String[] args) {


        String pattern = "pu";
        String string = "vipul";

//        System.out.println(Arrays.toString(buildLsp("abcaby")));
//        System.out.println(Arrays.toString(buildLsp("acacabacacabacacac")));


        System.out.println(findSubString(pattern, string, buildLsp(pattern)));

    }

}
