package xhang.leetcode;

/**
 * @Author xhang
 * 206. 反转链表 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class P206ReverseList {

    /**
     * 使用递归
     * @param head
     * @return
     *
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next); //递归反转链表
        head.next.next = head; //反转之后head.next.next是null，需将其指向head
        head.next = null; //head为最后一个节点，将head的next置空
        return newHead;
    }

    /**
     * 使用迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != null){
            nxt = cur.next; // nxt指针后移到下一个节点
            cur.next = pre; // cur的下一个节点指向pre，实现部分反转
            pre = cur; // pre后移
            cur = nxt; // cur后移
        }
        return pre;
    }
}
