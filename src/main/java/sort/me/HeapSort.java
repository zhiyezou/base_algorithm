package sort.me;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 7, 2, 3, 1};
        getMaxHeap(arr,0);
        heapSort(arr);
        //heapInsert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void getMaxHeap(int[] arr, int p) {
        int length = arr.length - 1 - p;
        for (int i = 0; i < length; i++) {
            while (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapInsert(int[] arr) {
        int i = arr.length - 1;
        arr[i] = 8;
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapify(int[] arr) {
        arr[0] = 1;
        int i = 0;
        while (2 * i + 1 < arr.length - 1) {
            if (arr[2 * i + 1] > arr[2 * i + 2])
                swap(arr, i, (2 * i + 1));
            i = 2 * i + 1;
        }
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            getMaxHeap(arr,arr.length-i-1);
        }
    }
}
