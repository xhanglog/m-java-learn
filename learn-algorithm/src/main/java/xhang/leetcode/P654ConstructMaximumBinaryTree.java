package xhang.leetcode;

/**
 * @Author xhang
 *
 * 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

/*
   输入  [3,2,1,6,0,5]
   先找到数组中的最大值 6，构建一个节点
   构造的节点的左子树为 [3,2,1]，右子树为 [0,5]
   从左子树和右子树中找到最大值依次构建树
 */
public class P654ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    /**
     * 构造树节点
     * @param nums 需要构造为树的数组
     * @param low 左下标
     * @param high 右下标
     * @return
     */
    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) return null;

        // index 保存最大值的下标
        int index = low, maxVal = nums[low];
        // 循环找到最大值和最大值下标
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        // 构造树节点
        TreeNode root = new TreeNode(maxVal);
        // 左子树为左边数组
        root.left = buildTree(nums, low, index -1);
        // 右子树为右边节点
        root.right = buildTree(nums, index + 1, high);
        return root;
    }
}
