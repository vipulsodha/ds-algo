package hackerrank.candies;




import java.util.*;


public class Solution {

    static long candies(int n, int[] arr) {
        // Complete this function


        int [] values = new int[n];

        Arrays.fill(values, 1);

        long count = 0;

        for (int i = 1; i < n; i ++) {
            if(arr[i-1] < arr[i]) {
                values[i] = values[i - 1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i --) {
            if(arr[i+1] < arr[i] && values[i] <= values[i+1]) {
                values[i] = values[i+1] + 1;
            }
        }

        for (int i = 0; i < n; i ++) {
            count += values[i];
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}

