package basic.class_01;

import java.util.Arrays;

/**
 * 完全二叉树
 * 时间复杂度O(N*logN),空间复杂度O(1)
 * 1.堆结构的heapinsert与heapify
 * 2.堆结构的增大和减少（一个数的代价是O（logN））
 * 3.如果只是建立堆的过程，时间复杂度为O（N）
 * 4.优先级队列结构，就是堆结构
 * <p>
 * 位置i，其左孩子的下标是2*i+1,右孩子的下标是2*i+2,父亲节点是(i-1)/2
 * <p>
 * 大根堆：堆就是完全二叉树，在这个完全二叉树中，任何一个子树的最大值都是头部
 * 小根堆：堆就是完全二叉树，在这个完全二叉树中，任何一个子树的最小值都是头部
 */

public class Code_03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //(1)形成大根堆，但未必有序
        for (int i = 0; i < arr.length; i++) {//0-i形成大根堆，每次扩一个位置的数
            heapInsert(arr, i);//只是和数的高度进行调整，和其他点没有关系，加入一个节点的时间复杂度是O（logN），（log1+log2+...logN-1）=O(N)
        }
        int size = arr.length;
        //(2)最后一个位置和堆顶位置交换，交换后最大值来到了数组的最后位置，堆大小减去1
        swap(arr, 0, --size);
        //(3)从0位置作heapify，重新形成大根堆
        while (size > 0) {
            heapify(arr, 0, size);
            //（4）交换倒数第二个位置上的数
            swap(arr, 0, --size);
        }
    }

    //0-i位置也是一个完全二叉树

    /**
     * heapinsert（上浮）
     * 如果你已经形成了一个堆，你要加上一个新的节点入堆，要经历向上依次比对，这个值如果大于父亲节点就往上跑，跑到某一个位置停（不比父亲节点大的位置）
     * 经历一个新节点加到这个堆里面，同时往上调整的过程就是heapinsert
     */
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);//大就往上换
            index = (index - 1) / 2;
        }
    }

    /**
     * heapify（下沉）
     * 假设数组中有一个值发生了变化了，变小了，如何重新调整为大根堆
     * 1.先找到他的左右孩子，找到两个孩子中的最大值
     * 2.再看他左右他两个孩子中较大的那个比不比当前的值大
     * 3.大就交换
     */
    public static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);//largest一定不是当前数
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }

}
