package xhang.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author xhang
 * Date 2020/6/7
 * 面试题40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 **/
public class GetLeastNumbers {

    /**
     * 使用大顶堆，堆中存放 k 个元素，当堆中个数大于等于 k 时，每次入堆时与堆顶元素比较
     * 最后将堆中的元素输出即可
     * Java 中可以使用 PriorityQueue 队列实现
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length < 0 || k <= 0) {
            return new int[0];
        }
        //因为PriorityQueue默认是从小到大排列的，所以需要使用comparator重写
        Queue<Integer> queue = new PriorityQueue<>((t1, t2) -> (t2 - t1));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() > num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }

        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


    /**
     * 快速查找，使用分治法，类似快速排序的方法
     * 定义一个基准数，大的数在右边，小的在左边
     * 如果左边的数的个数等于 k 则返回
     * 如果左边的个数 n 小于 k，则返回左边的数和右边寻找 k-n 个数
     * 如果左边的个数 n 大于 k，则在左边寻找 k 个数
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }else if (k > arr.length-1){
            return arr;
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int left, int right, int k) {
        int vv = nums[left];//以最左边的值为参考
        int low = left;
        int high = right+1;
        while (true){
            while (nums[++low] < vv)
                if (low == right)
                    break;
            while (nums[--high] > vv)
                if (high == left)
                    break;
            if (low >= high)
                break;
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        nums[left] = nums[high];
        nums[high] = vv;

        if (high == k) {
            return Arrays.copyOf(nums, high + 1);
        }
        return high > k? quickSearch(nums, left, high - 1, k): quickSearch(nums, high + 1, right, k);
    }




    public static void main(String[] args) {
        int arr[] = {0,1,6,2,0,1};
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers1(arr, 5);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
