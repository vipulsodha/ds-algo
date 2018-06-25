package singaporeSkii;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vipulsodha on 24/06/18.
 */
public class Solution {

    private static int[][] map;
    private static int[][] memoize;


    private static int findLongestPath( int prevNode, int i, int j) {

        if (i < 0 || i > map.length-1 || j > map[0].length -1 || j < 0) {
            return 0;
        }

        if (prevNode <= map[i][j]) {
            return 0;
        }


        if (memoize[i][j] != -1) {

            return memoize[i][j];
        }

        int left = findLongestPath( map[i][j], i, j-1);
        int right = findLongestPath( map[i][j], i, j+1);
        int top = findLongestPath( map[i][j], i-1, j);
        int bottom = findLongestPath( map[i][j], i+1, j);

        memoize[i][j] = 1 + Math.max(Math.max(left, right), Math.max(top, bottom));

        return memoize[i][j];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int max = -1;

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        map = new int[rows][columns];
        memoize = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                map[i][j] = scanner.nextInt();
                memoize[i][j] = -1;

            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                int tempMax = findLongestPath(Integer.MAX_VALUE, i, j);
                max = tempMax>max ? tempMax : max;

            }
        }


        System.out.println(max);

        scanner.close();
    }
}


