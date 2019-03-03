package sort.std.interview;

/**
 * 为什么归并排序可以加速
 * 插入排序，冒泡排序有很多无效的对比
 * <p>
 * 小范围在合大范围的时候，因为有序是可以通过外排方式来加速
 * <p>
 * 两个有序范围的东西合的过程中，不会浪费比较
 * <p>
 * 组内比较的次数不会被浪费，永远都是在跨组比较
 */
public class SmallSum {
    public static void main(String[] args) {

        //int[] arr = {1, 3, 4, 2, 5};
        //int []arr = {3, 1, 4, 5, 2};
        int []arr = {3, 1, 4, 5, 2,7,6};

        System.out.println(smallSum(arr));
    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;

        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }
}
