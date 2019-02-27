package sort.practice;

public class SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(smallSum(arr, 0, 4));

    }

    public static int smallSum(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return smallSum(arr, L, mid) + smallSum(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int mid, int R) {

        int[] helper = new int[arr.length];
        int i = 0;
        int res = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }

        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }

        for (int j = 0; j < i; j++) {
            arr[L + j] = helper[j];
        }
        return res;
    }
}
