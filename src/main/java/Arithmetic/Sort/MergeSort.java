package Arithmetic.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * <p>
 * 原理:  将两个排序好的子序列,合并成一个序列
 *
 * 空间复杂度:O(n)
 *
 * 时间复杂度:O( nlogn )
 */
public class MergeSort {
    public static void main(String[] args){
        int a[] = {42, 14, 52, 40, 28, 74, 48, 9, 22, 35, 61};
        mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    public static void mergeSort(int a[], int begin, int end){
        if(begin >= end)
            return;
        //使用递归完成排序
        int mid = (begin + end) >> 1;  //除以2
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);
    }
    //归并两路有序序列
    public static void merge(int a[], int begin, int mid, int end){
        int arr[] = new int[end + 1];  //临时数组保存排好序的数,使用[begin,end]区间
        int low = begin;  //临时数组的下标

        int left = begin;  //保存数组起始左下标
        int center = mid + 1;  //右路序列起始下标，左路为begin
        //将数组中小的保存到临时数组,若要降序把 > 换成 <
        while(begin <= mid && center <= end){
            arr[low++] = a[begin] > a[center] ? a[center++] : a[begin++];
        }
        //将上面while循环未移动的数字移入临时数组
        while(begin <= mid){
            arr[low++] = a[begin++];
        }
        while(center <= end){
            arr[low++] = a[center++];
        }
        //将临时数组中的数字保存到数组a
        for(int i = left; i <= end; i++){
            a[i] = arr[i];
        }
    }
}
