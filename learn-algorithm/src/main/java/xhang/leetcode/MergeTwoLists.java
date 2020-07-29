package xhang.leetcode;

/**
 * @Author xhang
 * 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeHead = null;
        if (l1.val <= l2.val) {
            mergeHead = l1;
            l1 = l1.next;
        } else {
            mergeHead = l2;
            l2 = l2.next;
        }
        ListNode temp = mergeHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }
        return mergeHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
