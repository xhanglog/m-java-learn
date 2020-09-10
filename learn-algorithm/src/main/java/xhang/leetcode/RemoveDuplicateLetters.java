package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 * 316. 去除重复字母
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 **/
public class RemoveDuplicateLetters {


    /**
     * 使用栈
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();

        int[] countarr = new int[26];
        int pos = 0;
        // 统计字符出现次数
        for (int i = 0;i < s.length();i++) {
            countarr[s.charAt(i) - 'a']++;
        }
        // 入栈，始终在原有顺序不变的情况下，保持字典最小的在前面
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (stack.contains(c)) {
                countarr[c - 'a']--;
                continue;
            }
            // 当前字符的值小于栈顶字符字典值且栈顶元素的个数在字符串中个数大于1时，将栈顶元素移除
            while (!stack.isEmpty() && stack.peek() > c && --countarr[stack.peek() - 'a'] > 0){
                stack.pop();
            }
            stack.push(c);
        }
        char[] ss = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ss[i] = stack.get(i);
        }
        return new String(ss);
    }

    public static void main(String[] args) {
        String a = "bddbccd";
        System.out.println(removeDuplicateLetters(a));
    }
}
