package quicksort;

import java.util.Arrays;

/**
 * Created by vipulsodha on 29/04/18.
 */
public class Solution {


    public static int partition(int [] arr, int l, int r) {

        int i = l -1;

        int pivot = arr[r];


        for (int j = l; j < r; j++) {

            if(arr[j] < pivot) {

                i = i +1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }

        i = i + 1;

        int temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;

        return  i;

    }



    public static void quickSort(int[] arr, int l, int r) {


        if(l < r) {

            int p = partition(arr, l, r);
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, r);

        }

    }



    public static void main(String[] args) {


        int [] arr = {3,8,5,4,9,2};

        quickSort(arr, 0, 5);

        System.out.println(Arrays.toString(arr));


    }




}
