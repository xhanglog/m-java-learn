package xhang.leetcode;

/**
 * @Author xhang
 * Date 2020/6/11
 * 面试题68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 *
 *
 *  二差排序树，根节点大于左子树的所有值，小于右子树的所有值
 *  有三种情况，
 *  1、当 p.val 和 q.val 均小于根节点的值时，那么此时的公共节点在左子树
 *  2、当 p.val 和 q.val 均大于根节点的值时，那么此时的公共节点在右子树
 *  3、以上两个条件都不满足的时候，根节点就是公共节点
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
