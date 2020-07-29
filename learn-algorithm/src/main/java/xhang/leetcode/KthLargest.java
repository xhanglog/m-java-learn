package xhang.leetcode;

import java.util.ArrayList;

/**
 * @Author xhang
 * Date 2020/6/10
 * 面试题54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 **/
public class KthLargest {

    /**
     * 二差排序树中序遍历是递增的  左-根-右
     * 右-根-左是降序的
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        dfs(root,res);
        return res.get(k-1);
    }

    void dfs(TreeNode root, ArrayList res){
        if (root == null){
            return;
        }
        dfs(root.right,res);
        res.add(root.val);
        dfs(root.left,res);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        KthLargest kthLargest = new KthLargest();
        System.out.println(kthLargest.kthLargest(treeNode,1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}


