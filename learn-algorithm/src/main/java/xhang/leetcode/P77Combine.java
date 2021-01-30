package xhang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author xhang
 *
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class P77Combine {

    List<List<Integer>> res = new ArrayList<>(); // 用于记录结果
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>(); // 记录路径
        trackBack(n, k, 1, track);
        return res;
    }

    public void trackBack(int n, int k, int start, LinkedList<Integer> track){
        // 路径长度等于 k 时将结果加入集合返回
        if (track.size() == k) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 加入选择列表
            track.add(i);
            // 递归调用
            trackBack(n, k, i+1, track);
            // 把值从选择列表移出
            track.removeLast();
        }
    }
}
