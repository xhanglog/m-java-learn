package xhang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xhang
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * https://leetcode-cn.com/problems/binary-tree-paths/
 **/
public class P257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getPaths(root, res, "");
        return res;
    }

    public void getPaths(TreeNode root, List<String> res, String cur){
        if (root != null) {
            StringBuffer sb = new StringBuffer(cur);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                res.add(sb.toString());
            }else {
                sb.append("->");
                getPaths(root.left, res, sb.toString());
                getPaths(root.right, res, sb.toString());
            }
        }

    }
}
