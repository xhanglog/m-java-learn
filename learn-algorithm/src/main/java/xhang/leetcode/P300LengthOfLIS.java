package xhang.leetcode;

import java.util.Arrays;

/**
 * @Author xhang
 *
 * 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P300LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        P300LengthOfLIS.lengthOfLIS(nums);
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 默认的长度为单个字符，长度为1
        for (int i = 0; i < n; i++) { // 根据归纳法填充dp数组
            for (int j = 0; j < i; j++) { // 每次需要遍历前i个子序列
                if (nums[j] < nums[i]) // 当前字符大于前面的序列时需要+1取最大值
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
