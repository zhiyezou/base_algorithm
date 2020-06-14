package basic.class_01;

import java.util.Arrays;


/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序
 * <p>
 * 借用的桶的概念，没有使用桶排序
 * <p>
 * N个数，准备N+1个桶
 * （1）先遍历数组最小值和最大值
 * （2）如果最大值和最小值相等，整个数组只有一种数
 * （3）不等，0号桶放最小值，n号桶放最大值
 * （4）中间值放到那个桶里呢，把最小值到最大值整个范围，等分成n+1份，一个数属于那个范围就放到哪个范围。
 * eg：0~99有9个数，准备10个桶，0放在0号桶，99放在9号桶，59放在5号桶
 * （5）N个数，N+1个桶，最小值放在了0号桶，最大值放在了N号桶，根据格隆原理，中间必然存在一个空桶。
 * （6）N个数在排序之后，相邻两个数可能来自同一个桶，也可能来自不同的桶
 * （7）设置空桶的目的，是否定最大差值一定不来自相同桶的数。空桶左边一定存在一个非空的桶，右边也可以找到一个离他最近非空的桶，那么他左边的最大值和右边的最小值排序后一定是相邻的，差值一定是大于桶所表达的范围的。
 * 我不用去管来自一个桶内部的两个数的差值，只会来自两个不同的桶的。
 * （8）每个桶中只记录进入桶中的最小值和最大值，boolean这个桶是否进来过数
 * （9）遍历每个桶，如果是空的则跳下一个，如果非空，则找到他左边离他最近的桶的最大值与当前桶的最小值的差值，每个桶都这样，记录的差值一定在这个差值之中。
 */
public class Code_11_MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {//找到数组中的最小值和最大值
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }

        //这三个数组就是每个桶要收集的3个信息
        boolean[] hasNum = new boolean[len + 1];//
        int[] maxs = new int[len + 1];//
        int[] mins = new int[len + 1];//
        int bid = 0;
        for (int i = 0; i < len; i++) {//再次遍历整个数组
            bid = bucket(nums[i], len, min, max);//确定一个数属于第几号桶
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {//找个每一个非空桶和离他最近的左边的非空的桶，用当前的最小，前一个的最大计算出差值
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
