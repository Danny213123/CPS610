// go through n different arrays concurrently

import java.util.concurrent.*;
import java.util.ArrayList;

class concurrent_run {
    public static void main(String[] args) {
        int n = 3;

        int[] arr1 = new int[1];
        int[] arr2 = new int[2];
        int[] arr3 = new int[3];

        arr1[0] = 1;

        arr2[0] = 2;
        arr2[1] = 3;

        arr3[0] = 4;
        arr3[1] = 5;
        arr3[2] = 6;

        int[] all_arr[] = {arr1, arr2, arr3};
        ArrayList<Integer> combined_arr = new ArrayList<Integer>();

        int index = 0;
        int arr_index = 0;

        for (int i = 0; i < n * n; i++) {

            if (index >= all_arr[arr_index].length) {
                //
            } else {
                combined_arr.add(all_arr[arr_index][index]);
            }

            arr_index++;

            if (arr_index == n) {
                arr_index = 0;
                index++;
            }

        }

        System.out.println(combined_arr);

    }
}