package xhang.datastructure.sort;

import java.util.Arrays;

/**
 * @Author xhang
 * Date 2020/2/15
 **/
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {3 , 52 , 67 , 57 , 720,4,23,1332,3123,34};
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {//数组为空或者长度为1直接返回
            return;
        }
        int max = arr[0];
        //获取最大数
        for (int i = 1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();//得到最大数的位数
        int[][] bucket = new int[10][arr.length];//定义一个二维数组作为桶
        int[] bucketCount = new int[10];//定义一个数组存放每个桶中的数据个数
        //循环maxLength完成排序，个位直接对10取模，十位除以10在对10取模，依次便可得到每个位上的数值大小
        for (int i=0,n=1;i<maxLength;i++,n *=10){

            //将数据放入到对应的桶中
            for (int j=0;j<arr.length;j++){
                int val = arr[j] / n % 10;//得到每个位上的数值大小（个位，十位，百位）
                bucket[val][bucketCount[val]] = arr[j];//将数组值放入对应的桶中
                bucketCount[val]++;//对应的桶中数据个数加一
            }

            //将数据从桶中取出，放入到数组
            int index = 0;//建立一个索引，便于遍历
            for (int k=0;k<bucketCount.length;k++){
                if (bucketCount[k] != 0){//当桶中数据个数不等于零时遍历
                    for (int m=0;m<bucketCount[k];m++){
                        arr[index++] = bucket[k][m];
                    }
                }
                bucketCount[k] = 0;//将桶的数据个数重新置零
            }
        }
    }

}
