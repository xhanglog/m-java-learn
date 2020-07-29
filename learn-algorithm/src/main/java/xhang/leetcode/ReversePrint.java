package xhang.leetcode;

import java.util.Stack;

/**
 * @Author xhang
 * 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 **/
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode cur = head;
        Stack<Integer> s = new Stack<>();
        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }
        int size = s.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = s.pop();
        }
        return arr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
