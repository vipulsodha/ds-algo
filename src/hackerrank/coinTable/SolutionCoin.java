package coinTable;


import java.util.Scanner;


public class SolutionCoin {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        int rowNumber = scanner.nextInt();
        int colNumber = scanner.nextInt();

        int K = scanner.nextInt();

        int starI = 0;

        int starJ = 0;

        char [][] data = new char[rowNumber+1][colNumber+1];

        int [][][] value = new int[rowNumber+2][colNumber+2][K+2];

        for(int i = 1; i <= rowNumber; i ++) {

            String row = scanner.next();

            for(int j = 1; j <= colNumber; j ++) {

                    data[i][j] = row.charAt(j-1);
            }

        }

        for(int i = 0; i <= rowNumber + 1; i ++) {

            for(int j = 0; j <= colNumber + 1; j ++) {

                for(int k = 0; k <= K; k ++) {

                    value[i][j][k] = 25000;

                }

            }
        }

        value[1][1][0] = 0;


        for(int k = 0; k <= K; k++) {

        for(int i = 1; i <= rowNumber; i ++) {

            for(int j = 1; j <= colNumber; j ++) {



                    switch (data[i][j]) {

                        case 'U':

                            value[i-1][j][k+1] = Math.min(value[i-1][j][k+1], value[i][j][k]);
                            value[i+1][j][k+1] = Math.min(value[i+1][j][k+1], value[i][j][k] + 1);
                            value[i][j+1][k+1] = Math.min(value[i][j+1][k+1], value[i][j][k] + 1);
                            value[i][j-1][k+1] = Math.min(value[i][j-1][k+1], value[i][j][k] + 1);

                            break;

                        case 'D':

                            value[i-1][j][k+1] = Math.min(value[i-1][j][k+1], value[i][j][k] + 1);
                            value[i+1][j][k+1] = Math.min(value[i+1][j][k+1], value[i][j][k]);
                            value[i][j+1][k+1] = Math.min(value[i][j+1][k+1], value[i][j][k] + 1);
                            value[i][j-1][k+1] = Math.min(value[i][j-1][k+1], value[i][j][k] + 1);

                            break;

                        case 'L':

                            value[i-1][j][k+1] = Math.min(value[i-1][j][k+1], value[i][j][k] + 1);
                            value[i+1][j][k+1] = Math.min(value[i+1][j][k+1], value[i][j][k] + 1);
                            value[i][j+1][k+1] = Math.min(value[i][j+1][k+1], value[i][j][k] + 1);
                            value[i][j-1][k+1] = Math.min(value[i][j-1][k+1], value[i][j][k]);


                            break;

                        case 'R':

                            value[i-1][j][k+1] = Math.min(value[i-1][j][k+1], value[i][j][k] + 1);
                            value[i+1][j][k+1] = Math.min(value[i+1][j][k+1], value[i][j][k] + 1);
                            value[i][j+1][k+1] = Math.min(value[i][j+1][k+1], value[i][j][k]);
                            value[i][j-1][k+1] = Math.min(value[i][j-1][k+1], value[i][j][k] + 1);

                            break;


                        case '*':

                            starI = i;

                            starJ = j;

                            break;

                    }
                }

            }

        }

    int result = 25000;

    for(int i = 0; i <= K; i ++ ) {

        result = Math.min(result, value[starI][starJ][i]);

    }


    if(result >= 25000) {
        System.out.println("-1");
    } else {
        System.out.println(result);
    }


    }




}
