package xhang.leetcode;

/**
 * @Author xhang
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P105BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length -1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 找到中序遍历的中间位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        int size = index - inStart;
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + size, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + size + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
