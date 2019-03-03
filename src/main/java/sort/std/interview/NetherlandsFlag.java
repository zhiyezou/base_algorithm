package sort.std.interview;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在中间，大于num的数放在数组的右边
 * <p>
 * 要求：额外空间复杂度O（1）时间复杂度O（N）
 */
public class NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 3, 6, 7, 3};
        partiton(arr, 0, arr.length - 1, 5);
        System.out.println(Arrays.toString(arr));
    }

    public static void partiton(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;

        int index = l;
        while (index < more) {
            if (arr[index] < p) {
                swap(arr, ++less, index++);
            } else if (arr[index] > p) {
                swap(arr, --more, index);//注意这里不能++，不确定交换回来的数是否比5大还是小，所以要再对这个下标的数据进行一次比较
            } else {
                index++;
            }

        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
