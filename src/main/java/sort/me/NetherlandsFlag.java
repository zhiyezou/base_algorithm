package sort.me;

import java.util.Arrays;

public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 3, 6, 7, 3};
        partiton(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));

    }

    public static void partiton(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;

        for (int i = l; i < r; i++) {
            if (i == more - 1) {
                return;
            }
            if (arr[i] < p) {
                less++;
                swap(arr, i, less);
            }

            if (arr[i] > p) {
                swap(arr, i, --more);
                partiton(arr, less + 1, more - 1, p);
            }

        }


    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
