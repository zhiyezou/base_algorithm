package sort.me;

/**
 * 小和问题
 * <p>
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和，求一个数组的小和。
 * <p>
 * 例子：
 * [1,3,4,2,5]
 * <p>
 * 1左边比1小的数，没有
 * 3左边比3小的数，1
 * 4左边比4小的数，1，3
 * 2左边比2小的数，1
 * 5左边比5小的数，1，3，4，2
 * 所以小和为1+1+3+1+3+4+2=16
 */
public class SmallSum {
    private static int sum;

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 2, 5};
        small(arr, 0, 4);
        System.out.println(sum);
        System.out.println(sum(arr,0,2,4));
    }

    public static void small(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        small(arr, L, mid);
        small(arr, mid + 1, R);
        sum = sum + sum(arr, L, mid, R);
    }

    public static int sum(int[] arr, int L, int mid, int R) {

        int sum = 0;
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            if (arr[p1] < arr[p2]) {
                //sum = sum + arr[p1];
                p1++;
            } else {
                p2++;
            }
        }

        if (p2 <= R) {
            for (int i = 0; i < p2; i++) {
                sum = sum + arr[i];
            }
        }
        return sum;
    }
}
