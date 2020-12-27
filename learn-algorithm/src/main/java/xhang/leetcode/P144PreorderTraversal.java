package xhang.leetcode;

import java.util.*;

/**
 * @Author xhang
 *
 * 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 **/

public class P144PreorderTraversal {

    //============================ 递归 ====================================
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    // 使用递归
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //============================ 迭代 ====================================

    /**
     * 迭代的方法进行遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
