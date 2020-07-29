package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
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
