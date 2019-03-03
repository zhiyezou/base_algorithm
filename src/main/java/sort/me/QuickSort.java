package sort.me;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 4, 3};
        System.out.println((int) Math.random() * (arr.length - 1));
        sortProcess(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortProcess(int[] arr, int l, int r) {
        if (l == r || l > r) {
            return;
        }
        //swap(arr, r, l+(int) (Math.random() * (arr.length - 1)));
        int[] lm = partition(arr, l, r, arr[r]);
        sortProcess(arr, l, lm[0]);
        sortProcess(arr, lm[1], r);
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int cur = l;
        while (cur < more) {
            if (arr[cur] < p) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > p) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
