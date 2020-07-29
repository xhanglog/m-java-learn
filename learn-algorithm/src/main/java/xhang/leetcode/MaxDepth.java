package xhang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author xhang
 * 面试题55 - I. 二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 **/
public class MaxDepth {

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int hight = 0;
        while (!queue.isEmpty()){
            for (int i=0,size=queue.size();i<size;i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            hight++;
        }
        return hight;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
