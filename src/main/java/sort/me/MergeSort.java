package sort.me;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 5, 2};
        //System.out.println(getMax(arr, 0, arr.length - 1));

        int[] result = mergeSort(arr, 0, 4);


        int[] arrL = {1, 3, 4};
        int[] arrR = {2, 5};
        System.out.println(Arrays.toString(arr));

    }

    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L + R) / 2;
        int maxL = getMax(arr, L, mid);
        int maxR = getMax(arr, mid + 1, R);
        return Math.max(maxL, maxR);
    }

    public static int[] mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return new int[]{arr[L]};
        }
        int mid = (L + R) / 2;
        int[] arrL = mergeSort(arr, L, mid);
        int[] arrR = mergeSort(arr, mid + 1, R);
        return merge(arrL, arrR);
    }

    public static int[] merge(int[] arrL, int[] arrR) {

        int[] arr = new int[arrL.length + arrR.length];

        int pL = 0;
        int pR = 0;
        int i = 0;

        do {
            if (arrL[pL] > arrR[pR]) {
                arr[i] = arrR[pR];
                pR += 1;
            } else {
                arr[i] = arrL[pL];
                pL += 1;
            }
            i++;
        } while (pL != arrL.length && pR != arrR.length);

        if (pL == arrL.length) {
            for (int j = pR; j < arrR.length; j++) {
                arr[i] = arrR[j];
                i++;
            }
        }

        if (pR == arrR.length ) {
            for (int j = pL; j < arrL.length; j++) {
                arr[i] = arrL[j];
                i++;
            }
        }
        return arr;
    }
}