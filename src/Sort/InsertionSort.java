package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
//        InsertionSort insertionSort = new InsertionSort();
        int[] arr = new int[]{4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;

        for (int i = 1; i < n; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex != i - 1){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
