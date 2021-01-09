package xhang.leetcode;

/**
 * @Author xhang
 *
 * 5. 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 **/
public class P05LongestPalindrome {

    /**
     * 从中间开始向两边扩散判断回文串
     * 回文串长度可能为奇数也可能为偶数
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        if (s.length() <= 1) {
            return s;
        }
        // 循环遍历字符串
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i); // 字符串长度为奇数时，返回以 i 为中心的字符串
            String s2 = palindrome(s, i, i+1);// 字符串长度为偶数时，返回以 i 和 i+1 为中心的字符串
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
            if(res.length() == s.length()) break;// 当回文字符串的长度等于字符串长度时，跳出循环
        }
        return res;
    }

    /**
     * 获取一个最长的回文字符串
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String palindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 左右指针同时移动
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
