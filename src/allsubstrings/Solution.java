package allsubstrings;

public class Solution {


    public static void main(String[] args) {



        String test = "abcde";


        for (int i = 0; i < test.length(); i++) {


            for (int j = 1; j <= test.length() - i; j++) {


                for (int k = 0; k < j; k++) {

                    System.out.print(test.charAt(k + i));

                }

                System.out.println(" ");

            }

        }

    }
}
