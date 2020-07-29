package xhang.leetcode;

/**
 * @Author xhang
 * 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 **/
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        } else if (head.val == val) {
            return head.next;
        } else {
            ListNode cur = head.next;
            ListNode pre = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                    break;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
