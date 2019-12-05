package Arithmetic.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 *
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定的
 */
public class BubbolSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {//外层循环控制
            for (int j = 0; j < array.length-1 - i; j++) {//内层循环控制每一趟排序多少次
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arrays = new int[]{199, 2, 33, 22, 14, 643, 64, 3, 1, 2};
        sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
