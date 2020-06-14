package basic.class_01;

public class Summary {

    //排序算法的稳定性及其汇总
    /**
     *稳定性是指排序中相同的值，排序之后能否保证原始次序不变。
     *
     * 稳定：（前面的值不会跨到相同值的后面去，后面的值也不会跨到相同值的前面去）
     * （1）冒泡：等于的时候不交换
     * （2）插入：等于的时候不往前插入
     * （3）归并：左右相等时，先拷贝左边的
     *
     * 非基于比较的
     * （4）桶
     * （5）计数
     * （6）基数
     *
     * 不稳定：
     * （1）选择：选择最小值会和0位置上的数交换
     * （2）快速：partition过程做不到稳定性（强行规定时间复杂度O(N),空间负责度O(1)）
     * （3）堆：完全二叉树，交换时候不会care想等值
     *
     * 稳定性的意义：排序之前的信息很重要，我想保留下来
     */

    //系统中的综合排序
    /**
     * 给定一个大数组
     * 1.判断数组中装的是基础类型还是class类型
     * 2.基础类型，快排（相同值无差异），class类型用归并排序（稳定性）
     * 3.数组长度很短，用插排（常数项极低，魔数60，小于60的时候用插排会很快）
     */

    //桶排序、计数排序、基础排序
    /**
     * 1.非基于比较的排序，与被排序的样本的实际数据情况很有关系，所以实际中并不经常使用
     * 2.时间复杂度O(N)，额外空间复杂度O（N）
     * 3.稳定的排序
     */
}
