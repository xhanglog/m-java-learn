package xhang.leetcode;

/**
 * @Author xhang
 * 226. 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/
 **/
public class P226InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
