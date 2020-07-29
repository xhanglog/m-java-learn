package xhang.leetcode;

/**
 * @Author xhang
 * Date 2020/6/17
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 **/

/**
 * 平衡二叉树的左右子树高度差要小于等于1，数的高度等于左右子树的最大高度加1
 */
public class IsBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left) - depth(root.right)) <= 1);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : (Math.max(depth(root.left), depth(root.right)) + 1);
    }

    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
