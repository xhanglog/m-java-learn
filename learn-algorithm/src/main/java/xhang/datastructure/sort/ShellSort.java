package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * Date 2020/2/15
 **/
public class ShellSort {

    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1直接返回
            return;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {//初始步长(增量)为数组长度的一半
            //创建一个循环，对每一个组的元素进行排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;//待插入位置的索引
                int temp = arr[j];//临时保存待插入元素值
                if (arr[j] < arr[j - gap]) {//如果当前元素的数小于其前一位的数，需要插入排序
                    while (j - gap >= 0 && temp < arr[j - gap]) {//循环移位找出插入该元素的位置
                        arr[j] = arr[j - gap];//移位
                        j -= gap;
                    }
                    arr[j] = temp;//插入元素
                }
            }
        }
    }

}
