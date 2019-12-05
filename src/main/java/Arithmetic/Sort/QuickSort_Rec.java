package Arithmetic.Sort;

import java.util.Arrays;

public class QuickSort_Rec {
    public static void main(String[] args) {
        int[] a = {6, 8, 5, 9, 3, 7};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort(int[] array, int start, int end) {

        int left = start;
        int right = end;
        if (left < right) {//保证array至少有两个元素
            int key = array[left];//将数组的起始值付给基准数
            while (left != right) {//结束条件为 left==right
                while (right > left && array[right] >= key)//首先从右边开始寻找比基准数小的值
                    right--;
                array[left] = array[right];//找到后和基准数交换位置
                while (left < right && array[left] <= key)//然后从左边开始寻找比基准数大的值
                    left++;
                array[right] = array[left];//找到后和基准数交换位置
            }
            array[right] = key;//基准数归位 一轮排序完成

            quickSort(array, start, left - 1);//对基准数左侧数据重复以上排序（递归）

            quickSort(array, right + 1, end);//对基准数右侧数据重复以上排序（递归）
        }
    }
}
