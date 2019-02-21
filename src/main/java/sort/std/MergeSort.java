package sort.std;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 5, 2};

        sortProcess(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    /**
     * 归并排序的重点是在merge过程，所谓merge就是想办法把两个有序的数据变成全局有序；
     * 这个操作没办法在原地完成，需要借助一个辅助数组来存放排序好的数组，最终将整个数组覆盖掉原有数组
     * @param arr
     * @param L
     * @param mid
     * @param R
     */
    public static void merge(int[] arr, int L, int mid, int R) {

        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //两个必有且只有一个越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        //覆盖原有数据
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
