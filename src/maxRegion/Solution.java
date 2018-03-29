package maxRegion;

import java.util.Scanner;

public class Solution {


    public static int calculate(int [][] arr, int i, int j) {


        int point = 0;

        if(i > arr.length - 1 || i < 0 || j > arr[0].length -1 || j < 0 ) {
            return point;
        }


        if(arr[i][j] == 1) {

            point = 1;
            arr[i][j] = 0;
        } else {
            return point;
        }


        return calculate(arr, i+1, j -1) + calculate(arr, i+1, j + 1)+ calculate(arr, i-1, j +1)+ calculate(arr, i-1, j -1)  +calculate(arr, i+1, j)
                + calculate(arr, i-1, j) + calculate(arr, i, j + 1) + calculate(arr, i, j - 1) + point;

    }


    static int connectedCell(int[][] matrix, int n, int m) {


        int maxValue = 0;


        for(int i = 0; i < n ; i ++) {

            for(int j = 0; j < n ; j ++) {


                if(matrix[i][j] == 1) {

                    int tempValue = calculate(matrix, i, j);

                    if(tempValue > maxValue) {
                        maxValue = tempValue;
                    }

                }

            }
        }



        return maxValue;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for(int matrix_i = 0; matrix_i < n; matrix_i++){
            for(int matrix_j = 0; matrix_j < m; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        int result = connectedCell(matrix, n ,m);
        System.out.println(result);
        in.close();
    }
}
