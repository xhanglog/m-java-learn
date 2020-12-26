package xhang.leetcode;

/**
 * @Author xhang
 *
 * 树节点定义
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, xhang.leetcode.TreeNode left, xhang.leetcode.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
