package xhang.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author xhang
 * 1190. 反转每对括号间的子串
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ReverseParentheses {

    public static String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 将左括号的坐标放入到栈中
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                reverse(chars, stack.pop() + 1, i-1);
            }
        }

        // 输出数组的内容
        for (char aChar : chars) {
            if (aChar !='(' && aChar != ')')
                res.append(aChar);
        }
        return res.toString();
    }

    // 反转括号内的内容
    private static void reverse(char[] chars, int start, int end) {
        while (end > start) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        String s = "a(bcdefghijkl(mno)p)q";
        System.out.println(reverseParentheses(s));
    }
}
