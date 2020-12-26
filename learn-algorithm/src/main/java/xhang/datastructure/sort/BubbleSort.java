package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * 冒泡排序
 * Date 2020/2/15
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = null;
        BubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2 ){
            return;
        }
        int temp = 0;//定义一个临时变量
        boolean flag = false;//设置一个标识判断是否已经有序
        for (int i = 0; i < arr.length - 1; i++) { // 对于 n 个元素需要进行 n-1 轮排序
            for (int j = 0; j < arr.length - i - 1; j++) { // 每一轮排序需要进行比较的次数，如 i=0,n=4 时，比较次数 = n - i -1 = 3，
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;//有交换，还不是有序的，置为true
                }
            }
            if (!flag) {
                break;//后续的序列有序，跳出循环
            } else {
                flag = false;//将标志重新置为false
            }
        }
    }

}
