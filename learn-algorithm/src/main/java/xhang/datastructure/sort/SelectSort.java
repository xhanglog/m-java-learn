package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * Date 2020/2/15
 **/
public class SelectSort {

    public static void main(String[] args) {
        int arr[] = {10};
        SelectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1直接返回
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {//当遍历次数为数组长度-1时，数组排序完成
            int min = arr[i];//假设当前第一个值为最小值，临时变量存储最小值
            int minIndex = i;//临时变量存储最小值的索引
            for (int j = i + 1; j < arr.length; j++) {//遍历从i+1个元素开始
                if (min > arr[j]) {//当前min保存的不是最小值
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) { //当前保存的值是最小值，不需要在进行赋值
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

}
