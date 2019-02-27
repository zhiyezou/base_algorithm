package sort.std;

import java.util.Arrays;

public class RightMethod {
    public static void main(String[] args) {
        int testTime=50000;
        int size=10;
        int value=100;
        boolean succeed=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1=generateRandomArray(size,value);
            int[] arr2=copyArr(arr1);
            //1
            //2
            /*if(!isEqual(arr1,arr2)){
                succeed=false;
            }*/
        }
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
    public static int[] copyArr(int[] arr){

        return null;
    }
}
