package sort.practice;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {-14, 7, -77, -35, -25, -6, -60, -64, -89};
        heapSort1(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        heapInsert(arr);
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

    }


    public static void heapify(int[] arr, int heapSize) {
        int i = 0;
        int left = 2 * i + 1;
        int right = left + 1;
        int tmp = 0;
        while (left < heapSize) {
            //int right = left + 1;//为什么得放到里面才会生效
            if (right < heapSize) {
                tmp = arr[left] > arr[right] ? left : right;
            } else {
                tmp = left;
            }
            if (arr[i] < arr[tmp]) {
                swap(arr, i, tmp);
                i = tmp;
                left = 2 * i + 1;
                right = left + 1;//在这里，你right也要跟着变
            } else {
                break;
            }
        }
        /*int left = i * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[i] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(arr, largest, i);
            i = largest;
            left = i * 2 + 1;
        }*/
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void heapInsert1(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify1(int[] arr, int index, int heapSize) {

        int left = 2 * index + 1;
        while (left < heapSize) {
            int right = left + 1;
            int largest = 0;
            if (right < heapSize) {
                largest = arr[right] > arr[left] ? right : left;
            } else {
                largest = left;
            }
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert1(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify1(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }
}
