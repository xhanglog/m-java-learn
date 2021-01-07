package xhang.leetcode;

/**
 * @Author xhang
 * 814. 二叉树剪枝
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P814PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return cutTree(root) ? root: null;
    }

    public boolean cutTree(TreeNode root){
        if (root == null){ // 节点为空，跳出递归
            return false;
        }
        boolean left = cutTree(root.left); // 对节点的左子树进行递归
        boolean right = cutTree(root.right); // 对节点的右子树进行递归
        if (!left) root.left = null; // 减掉左边的子树
        if (!right) root.right = null; // 减掉右边的子树
        return root.val == 1 || left || right; // 值为1或者节点有左右子树
    }
}
