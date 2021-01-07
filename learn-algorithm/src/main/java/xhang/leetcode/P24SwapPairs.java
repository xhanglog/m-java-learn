package xhang.leetcode;

/**
 * @Author xhang
 * 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 **/
public class P24SwapPairs {

    /************* 法1：递归  ****************/
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head; // base条件，节点为空或者节点下一个节点为空时直接返回
        ListNode newHead = head.next; // 新的头节点是第二个节点
        head.next = swapPairs(newHead.next); // 递归
        newHead.next = head; // 新的头节点需要指向旧节点
        return newHead;
    }

    /************* 法2：迭代  ****************/
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tempHead = new ListNode(0); // 定义一个虚拟节点
        tempHead.next = head;
        ListNode temp = tempHead;
        while (temp.next != null && temp.next.next != null) { // 当只剩下一个节点或者0个节点时退出循环
            ListNode pre = temp.next;
            ListNode last = temp.next.next;
            temp.next = last;
            pre.next = last.next;
            last.next = pre; // 遍历完后 2 -> 1 -> 3 -> 4
            temp = pre;
        }
        return tempHead.next;
    }
}
