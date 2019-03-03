package sort.practice;

import java.util.Arrays;

public class NetherlandsFlag {
    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 2, 5};
        System.out.println(Arrays.toString(partition(arr, 0, 4, 3)));
        System.out.println(Arrays.toString(arr));
    }

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int cur = less + 1;
        while (cur != more) {
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
