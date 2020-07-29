package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 * Date 2020/5/15
 * 面试题30，包含min函数的栈
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈的
 *  最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *  https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 **/

/**
 *  解题思路：
 *  维护两个栈，一个保存正常的进出栈顺序，一个保存最小值栈
 *  按照入栈顺序在最小值栈添加当前的最小值
 *  出站的时候正常栈同最小值栈同时出栈
 */
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            Integer curMin = minStack.peek(); //获取最小值栈的当前最小值
            if (curMin >= x){
                minStack.push(x);
            }else {
                minStack.push(curMin);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
