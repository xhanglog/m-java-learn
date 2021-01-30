package xhang.leetcode;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author xhang
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，
 * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P503NextGreaterElements {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] arr = new int[]{1,2,1};
        nextGreaterElements(arr);
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        // 循环数组需要遍历两倍长度，保证每个数都能进栈出栈两次，通过取模运算获得数组下标
        for(int i = 0; i < 2 * nums.length - 1; i++) {
            int index = i % nums.length; // 取模，实现循环数组
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) { // 找到下一个更大元素
                res[stack.pop()] = nums[index]; // 栈中保存的是索引
            }
            stack.push(index);
        }
        return res;
    }
}
