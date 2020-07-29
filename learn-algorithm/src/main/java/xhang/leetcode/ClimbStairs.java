package xhang.leetcode;

/**
 * @Author xhang
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 **/
public class ClimbStairs {

    /**
     * 本体使用动态规划来求解
     * 1阶楼梯有1个解法
     * 2阶楼梯可以是 1阶+1阶 等于两种方法
     * 3阶楼梯可以由1阶和2阶方法和得到
     * 即：n阶楼梯可由 (n-1) 阶和 (n-2) 的方法数和得到
     * 由此可知格式 dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
