package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 * 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class CQueue {

    Stack<Integer> numStack;
    Stack<Integer> tempStack;
    int size;
    public CQueue() {
        numStack = new Stack<>();
        tempStack = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        if (numStack.isEmpty()){
            numStack.push(value);
        }else {
            while (!numStack.isEmpty()){
                tempStack.push(numStack.pop());
            }
            numStack.push(value);
            while (!tempStack.isEmpty()){
                numStack.push(tempStack.pop());
            }
            size++;
        }
    }

    public int deleteHead() {
        if (numStack.isEmpty()){
            return -1;
        }else {
            size--;
            return numStack.pop();
        }
    }
}
