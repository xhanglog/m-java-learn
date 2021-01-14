package xhang.leetcode;

/**
 * @Author xhang
 *
 * 516. 最长回文子序列
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 **/
public class P516LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 初始化dp数组，i==j时表示只有一个字符，此时最长回文子序列为1
        // 一个字符串，i在左边，j在右边，i>j时dp[i][j]为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // 求dp[i][j]，在求出dp[i+1][j-1]的情况下
        // 如果i对应的字符等于j对应的字符，则dp[i][j] = dp[i+1][j-1] + 2
        // 如果不等，则左右对应的字符至少有一个不存在于最长回文子序列中，dp[i][j] = Max(dp[i-1][j-1],dp[i][j-1],dp[i+1][j])
        // 反着遍历
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
