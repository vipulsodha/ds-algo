package countLuck;


import java.util.*;


public class Solution {


    public static boolean calculate(String[][] arr, int i, int j, Map<Integer, Integer> count, int n, int m, int k) {


        boolean isOnStarPath = false;

        if(i >= n || i < 0 || j >= m || j < 0 || arr[i][j].equals("X")  ) {
            return false;
        }


        if(arr[i][j].equals("*")) {

            return true;

        } else {

            arr[i][j] = "X";

            int addCount = 0;

            if(i-1 >= 0 && !arr[i-1][j].equals("X") && !arr[i-1][j].equals("*")) {

                    addCount++;
            }

            if(i+1 < n && !arr[i+1][j].equals("X") && !arr[i+1][j].equals("*")) {

                    addCount++;
            }

            if(j-1 >= 0 && !arr[i][j-1].equals("X") && !arr[i][j-1].equals("*")) {

                    addCount++;

            }

            if(j+1 < m && !arr[i][j+1].equals("X") && !arr[i][j+1].equals("*")) {

                    addCount++;

            }

            isOnStarPath  = calculate(arr, i, j + 1, count, n, m, k) ? true : isOnStarPath;
            isOnStarPath  = calculate(arr, i-1, j, count, n, m, k)  ? true : isOnStarPath;
            isOnStarPath  = calculate(arr, i, j-1, count, n, m, k)  ? true : isOnStarPath;
            isOnStarPath  = calculate(arr, i+1, j, count, n, m, k)  ? true : isOnStarPath;


            if(addCount > 1 && isOnStarPath) {
                count.put(0, count.get(0)+1);
            }

            return isOnStarPath;

        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0,0);

        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();

            int startI = 0;
            int startJ = 0;

            String[][] matrix = new String[n][m];
            for(int matrix_i = 0; matrix_i < n; matrix_i++){

                String[] values = in.next().split("");



                for(int j = 0; j < m; j ++) {

                    matrix[matrix_i][j] = values[j];

                    if(values[j].equals("M")) {
                        startI = matrix_i;
                        startJ = j;
                    }
                }
            }


            int k = in.nextInt();

                    calculate(matrix, startI, startJ, count, n, m, k);

            System.out.println(count.get(0));
                    System.out.println(count.get(0) != k ? "Opps" : "Impressed");
                    count.put(0,0);


        }
        in.close();
    }
}

