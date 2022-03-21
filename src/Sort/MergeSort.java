package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int[] tmp = new int[right - left + 1];
        int l = left, r = mid + 1, t = 0;
        while (l <= mid && r <= right){
            if (arr[l] <= arr[r]){
                tmp[t++] = arr[l++];
            }else {
                tmp[t++] = arr[r++];
            }
        }
        while (l <= mid){
            tmp[t++] = arr[l++];
        }
        while (r <= right){
            tmp[t++] = arr[r++];
        }
        t = left;
        for (int num : tmp) {
            arr[t++] = num;
        }
    }
}
