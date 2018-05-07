package mergesortt;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static void merge(int[] arr, int l, int r, int mid) {

        int n1 = mid-l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = l; i < mid; ++i) {

                L[i] = arr[i];
        }

        for (int i= mid+1; i < r; ++i) {
            R[i] = arr[i];
        }


        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }

    }


    private static void  mergeSort(int[] arr, int l, int r) {

        if (l < r) {

            int mid = (l+r)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, r, mid);

        }

    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = in.nextInt();

        }

        mergeSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));




    }
}
