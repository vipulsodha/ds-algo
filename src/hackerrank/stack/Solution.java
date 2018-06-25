package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;


/**
 * @author sodha
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 */
public class Solution {




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int count = scanner.nextInt();


        Stack<Event> eventStack = new Stack<>();

        String S = "";

        while (count > 0) {

            int operation = scanner.nextInt();


            switch (operation) {


                case 1:


                    String appendString = scanner.next();

                    Event event = new Event(operation, "", S.length());

                    eventStack.push(event);

                    S += appendString;

                    break;
                case 2:


                    int deleteCount = scanner.nextInt();

                    int deleteIndex = S.length() - deleteCount;

                    String deletedString = S.substring(deleteIndex);

                    S = S.substring(0, deleteIndex);

                    Event deleteEvent = new Event(operation, deletedString, 0);

                    eventStack.push(deleteEvent);

                    break;

                case 3:

                    int k = scanner.nextInt();

                    System.out.println(S.charAt(k - 1));

                    break;

                case 4:



                    Event undoEvent = eventStack.pop();

                    switch (undoEvent.type) {


                        case 1:

                            S = S.substring(0, undoEvent.appendIndex);

                            break;

                        case 2:

                            S = S + undoEvent.deleteString;

                            break;



                    }


                    break;

            }

        }

    }
}



class Event {

    public Event(int type, String deleteString, int appendIndex) {
        this.type = type;
        this.deleteString = deleteString;
        this.appendIndex = appendIndex;
    }

    int type;

    String deleteString;

    int appendIndex;
}