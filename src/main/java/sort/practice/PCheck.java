package sort.practice;


import java.util.Arrays;

public class PCheck {
    public static void main(String[] args) {
        int testTime = 50000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArr(arr1);
            int[] arr3 = copyArr(arr1);
            //test method
            //BubbleSort.bubbleSort(arr1);//Nice
            //InsertSort.insertSort(arr1);//Nice
            //MergeSort.mergeSort(arr1);//Nice
            //SelectionSort.selectionSort(arr1);//Nice
            //QuickSort.quickSort(arr1);//Nice
            HeapSort.heapSort2(arr1);//Nice
            //test method
            rightMethod(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.println(Arrays.toString(arr3));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking Fucked");
    }

    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    public static int[] copyArr(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        return res;
    }

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
}
