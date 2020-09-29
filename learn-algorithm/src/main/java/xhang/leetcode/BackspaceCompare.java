package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 *
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/
 **/
public class BackspaceCompare {

    public static boolean backspaceCompare(String S, String T) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0;i < S.length();i++) {
            if (S.charAt(i) == '#' && !stackS.isEmpty()) {
                stackS.pop();
            }
            if (S.charAt(i) != '#') {
                stackS.push(S.charAt(i));
            }
        }
        for (int j = 0;j < T.length();j++) {
            if (T.charAt(j) == '#' && !stackT.isEmpty()) {
                stackT.pop();
            }
            if (T.charAt(j) != '#') {
                stackT.push(T.charAt(j));
            }
        }
        if (stackS.size() != stackT.size())
            return false;
        int size = stackS.size();
        for (int i = 0;i < size;i++) {
            if (stackS.peek() != stackT.peek()) {
                return false;
            }
            stackS.pop();
            stackT.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "abcd";
        String T = "bbcd";
        System.out.println(backspaceCompare(S, T));
    }

}
