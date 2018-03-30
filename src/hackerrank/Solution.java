package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vipulsodha on 08/03/18.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String values = "";

        Stack<String> states = new Stack<>();


        int numberOperations = scanner.nextInt();


        for (int i = 0; i < numberOperations; i++) {


            String input = scanner.next();

            String[] inputValues = input.split(" ");

            String state = "";

            switch (inputValues[0]) {


                case "1":

                        values += inputValues[1];

                         state  = "1" + " " + inputValues[1];

                    states.push(state);

                    break;

                case "2":

                    int k = Integer.parseInt(inputValues[2]);

                    int size = values.length();


                    int finalSize = size - k;

                    if(finalSize == 0) {
                        values = "";
                    } else {

                        String temp = "";

                        for (int j = 0; j < finalSize; j++) {

                            temp += values.charAt(j);

                        }



                        String newTemp = "";

                        for(int j = finalSize; j < size; j ++) {
                            newTemp += values.charAt(j);
                        }

                        values = temp;

                         state = "2" + " " + newTemp;

                        states.push(state);

                    }



                    break;

                case "3":


                    int kth = Integer.parseInt(inputValues[1]);

                    System.out.println(values.charAt(kth-1));

                    break;

                case "4":


                    String undoState = states.pop();


                    String[] stateValues = undoState.split(" ");

                    switch (stateValues[0]) {


                        case "1":





                            break;

                        case "2":




                            break;

                    }

                    break;


            }



        }
    }









}
