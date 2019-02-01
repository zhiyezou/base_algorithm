package sort.me;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 5, 2};
        //System.out.println(getMax(arr, 0, arr.length - 1));

        int[] result = mergeSort(arr, 0, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            System.out.println("test");
        }
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
        int mid = L + (R - L) >> 1;
        int[] arrL = mergeSort(arr, L, mid);
        int[] arrR = mergeSort(arr, mid + 1, R);
        return merge(arrL, arrR);
    }

    public static int[] merge(int[] arrL, int[] arrR) {
        int[] arr = new int[arrL.length + arrR.length];

        int pL = 0;
        int pR = 0;
        int i = 0;
        arr[i] = arrL[pL] < arrR[pR] ? arrL[pL] : arrR[pR];

        while (pL != arrL.length - 1 && pR != arrR.length - 1) {
            arr[i] = arrL[pL] > arrR[pR] ? arrL[pR] : arrR[pL];
            if (arrL[pL] > arrR[pR]) {
                pR += 1;
            } else {
                pL += 1;
            }
            i++;
        }

        if (pL == arrL.length - 1) {
            for (int j = pR; j < arrR.length; j++) {
                i++;
                arr[i] = arrR[j];
            }
        } else {
            for (int j = pL; j < arrL.length; j++) {
                i++;
                arr[i] = arrL[j];
            }
        }
        return arr;
    }
}