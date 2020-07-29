package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * Date 2020/2/15
 **/
public class QuickSort {

    public static void main(String[] args) {
        int arr[] = {12, 10, 33, 6, 21, 3, 18, 1,4,20,80,15,6};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1直接返回
            return;
        }
        int low = left;//定义左指针
        int high = right;//定义右指针
        int pivot = arr[(left + right) / 2];//定义参考变量值
        int temp = 0;
        while (low < high) {//当左指针小于右指针时进行遍历排序
            while (arr[low] < pivot) {//从左边依次循环找出大于参考值的索引
                low++;//指针后移
            }
            while (arr[high] > pivot) {//从右边依次循环找出小于参考值的索引
                high--;//指针前移
            }
            if (low >= high) {//如果左指针大于大于右指针则退出循环
                break;
            }
            //交换值
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            if (arr[low] == pivot) {//当交换后，左指针指向的值等于参考值，右指针前移
                high--;
            }
            if (arr[high] == pivot) {//当交换后，左指针指向的值等于参考值，左指针前移
                low++;
            }
        }
        if(low == high){//左右指针相等时，左指针后移，右指针前移，防止栈溢出
            low++;
            high--;
        }
        if (left < high) {//左递归，对左边部分进行排序
            quickSort(arr, left, high);
        }
        if (right > low) {//右递归，对右边部分进行排序
            quickSort(arr, low, right);
        }
    }
}
