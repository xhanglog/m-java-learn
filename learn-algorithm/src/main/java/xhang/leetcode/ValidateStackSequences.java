package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
 * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // popped 数组的下标
        int length = popped.length;
        for (int v : pushed) {
            stack.push(v);
            // 当栈不为空，栈顶元素和出栈数组首元素相等时，出栈，下标+1
            while (!stack.isEmpty() && i < length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        // 全部出栈返回 true
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
