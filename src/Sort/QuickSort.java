package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,7,6,43,53,744};
        quickSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int i = left, j = right;
        int midVal = arr[(i + j) / 2];
        while (i < j){
            while (arr[i] < midVal) i++;
            while (arr[j] > midVal) j--;
            if (i == j) break;

            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            if (arr[i] == midVal) j--;
            if (arr[j] == midVal) i++;
        }
        if (i == j){
            i++;
            j--;
        }
        if (left < j){
            quickSort(arr, left, j);
        }
        if (i < right){
            quickSort(arr, i, right);
        }
    }
}
