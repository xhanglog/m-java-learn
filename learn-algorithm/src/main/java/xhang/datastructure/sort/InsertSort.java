package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * 插入排序
 * Date 2020/2/15
 **/
public class InsertSort {

    public static void main(String[] args) {
        int arr[] = {100, 20, 80, 8};
        InsertSort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1直接返回
            return;
        }
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < arr.length; i++) {//从第二个位置开始循环判断插入
            insertIndex = i - 1;//待插入元素位置索引
            insertVal = arr[i];//保存待插入元素的值
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {//当索引小0或者待插入元素的值小于待插入位置的值时候跳出循环
                arr[insertIndex + 1] = arr[insertIndex];//大的值后移
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;//将待插入元素插入到对应位置
        }
    }

}
