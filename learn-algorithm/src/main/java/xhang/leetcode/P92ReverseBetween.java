package xhang.leetcode;

/**
 * @Author xhang
 *
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P92ReverseBetween {

    /*********** 法1： 递归求解  *************/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1){ // m==1表示反转前n个节点
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
    }
    ListNode tail = null;
    // 反转前n个节点
    public ListNode reverseN(ListNode head, int n){
        if (head == null || head.next == null) return head;
        if (n == 1) { // n==1表示不反转直接返回head,记录下一个节点
            tail = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = tail;
        return newHead;
    }
}
