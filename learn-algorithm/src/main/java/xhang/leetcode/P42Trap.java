package xhang.leetcode;

/**
 * @Author xhang
 *
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P42Trap {
    public int trap(int[] height) {
        if (height.length == 0) {return 0;}
        int sum = 0;
        int m = height.length;
        int[] left_max = new int[m]; // 定义数组，保存当前节点左边的最大值
        int[] right_max = new int[m]; // 定义数组，保存当前节点右边的最大值
        left_max[0] = height[0];
        right_max[m - 1] = height[m - 1];
        // 遍历寻找左边最高的
        for (int i = 1; i < m; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        // 遍历寻找右边最高的
        for (int i = m - 2; i >= 0 ; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        // 左右最低的减去当前高度得到当前位置的储水量
        for (int i = 1; i < m - 1; i++) {
            sum += Math.min(left_max[i - 1], right_max[i + 1]) - height[i];
        }
        return sum;
    }
}
