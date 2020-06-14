package basic.class_01;

/**
 * 一：（partition）
 * 给定一个数组arr，一个数num，请把小于等于num的数放在数组左边，大于num的数放在数组的右边。
 * <p>
 * 要求额外空间复杂度O（1），时间复杂度O（N）
 * <p>
 * 二：
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 进阶：把数组L-R位置上的数调整。
 * <p>
 * 要求额外空间复杂度O（1），时间复杂度O（N）
 */

/**
 *
 */
public class Code_08_NetherlandsFlag {

    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;//指针停留在数组最左边-1的位置，从0-x上存放的都是小于num的数，小于区域不断扩大
        int more = r + 1;//指针停留在数组最右边+1的位置
        int cur = l;
        while (cur < more) {
            if (arr[cur] < p) {
                swap(arr, ++less, cur++);//把less的下一个位置与当前位置的数交换，换回来的数一定是等于p的数
            } else if (arr[cur] > p) {
                swap(arr, --more, cur);//把more的前一个数与当前的数据交换，换回来的数可能大于小于或等于p
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};//等于区域的下标，等于区域的左边界和右边界
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
