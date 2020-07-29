package xhang.leetcode;

/**
 * @Author xhang
 * 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 **/
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
