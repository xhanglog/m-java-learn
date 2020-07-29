package xhang.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author xhang
 * Date 2020/5/15
 * 面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 **/
public class MaxSlidingWindow {

    /**
     * 记录最大值的下标与值，每一次窗口滑动比较仅仅与上一次的最大值比较即可
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //数组长度为0退出
        if (nums.length == 0) {
            return new int[0];
        }
        //迭代次数
        int size = nums.length - k + 1;
        int res[] = new int[size];
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {

            if (maxIndex >= i){
                if (nums[i+k-1] > max){
                    max = nums[i+k-1];
                    maxIndex = i+k-1;
                }
            }else {
                //获取数组的最大值与下标
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }

    /**
     * 使用队列实现
     * 移动区间[i,i+k-1]
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        //数组长度为0退出
        if (nums.length == 0) {
            return new int[0];
        }
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList();
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            if(i > 0 && deque.peekFirst() == nums[i - 1]) deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) deque.removeLast();
            deque.addLast(nums[j]);
            if(i >= 0) res[i] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow max = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(max.maxSlidingWindow1(nums,3)));
    }
}
