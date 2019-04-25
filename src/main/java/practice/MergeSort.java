package practice;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 2, 5};
        sortProcess1(arr, 0, 4);
        //System.out.println(Arrays.toString(arr));

    }

    /**
     * 其实只需要arr一个参数就可以了，这里为啥要L和R这两个参数呢？
     * 更加通用，既能够对整个数组进行排序，又能对其中的子集进行排序
     * <p>
     * 他是个递归函数，如果没有L，R咋判断终止条件呢？
     * 也可以那就arr size=1的时候
     *
     * @param arr
     * @param L
     * @param R
     */
    public static void sortProcess1(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = L + ((R - L) >> 2);//和（R+L）/2的区别是啥？
        sortProcess1(arr, L, mid);
        sortProcess1(arr, mid + 1, R);
        merge1(arr, L, mid, R);

    }

    /**
     * 这个方法的目的呢就是要合并两个数组，应该给他传递两个数组参数，但是你的数据是在一个数组上的
     * 那么你怎么使用一个数组把他切分成两个数组呢
     * <p>
     * 这里很微妙，就是你把整个数组传递过去，利用L，mid，R这三个下标就能得到你想要的两个数组
     * （说到底其实他还是一个数组，只是在逻辑上进行了切分，需要两个指针来帮忙模拟两个数组）
     * <p>
     * 执行merge操作的前提呢，你给的两个数组已经有序，才能merge
     * <p>
     * 只是申请了一块和原有数组大小相等的空间，每次都是利用其暂存数据的功能
     *
     * @param arr
     * @param L
     * @param mid
     * @param R
     */
    public static void merge1(int[] arr, int L, int mid, int R) {

        int[] helper = new int[arr.length];
        int i = 0;//这里并不是要将原有数组按照下标将其赋值给helper对应的位置，只是暂时将其存放
        int p1 = L;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= R) {
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];//充分理解i++，++i的区别
        }

        //不管怎么样，肯定有一个没跑完，直接把剩下的赋值给helper即可
        while (p1 <= mid) {
            helper[i++] = arr[p1++];
        }

        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }

        for (int j = 0; j < i; j++) {
            arr[L + j] = helper[j];
        }
        System.out.println(Arrays.toString(helper));

    }
}
