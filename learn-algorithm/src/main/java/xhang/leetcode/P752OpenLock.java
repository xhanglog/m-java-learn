package xhang.leetcode;

/**
 * @Author xhang
 * 752. 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 使用回溯算法
 * 当匹配到目标值时返回结果，当遇到死亡数字时跳出循环
 *
 *  每一种密码组合可以得到 8 种新的组合，
 *  比如 0000可以得到，1000，9000，0100，0900,0010,0090,0001,0009
 * 回溯过程会遇到重复的密码组合，使用集合记录访问过的密码组合，防止走回头路
 */
public class P752OpenLock {

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends, "0202"));
    }

    public static int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>(); // 使用set记录死亡数组，方便判断
        for (String s : deadends) {
            deadend.add(s);
        }
        Set<String> visited = new HashSet<>(); // 记录访问过的密码
        Queue<String> queue = new LinkedList<>(); // 使用队列记录
        queue.offer("0000");
        visited.add("0000");
        int step = 0; // 记录所用的步数
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历一层的数据
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // 死亡数组里边包含当前密码，退出本次循环
                if (deadend.contains(cur)) {
                    continue;
                }
                // 当前密码等于目标密码返回步数
                if (target.equals(cur)) {
                    return step;
                }
                // 当前密码的八中情况加入队列
                for (int j = 0; j < 4; j++) {
                    String up = upOne(cur, j);
                    if (!visited.contains(up)) { // 没有访问过才加入
                        visited.add(up); // 加入访问结合
                        queue.offer(up); // 加入队列
                    }
                    String down = downOne(cur, j);
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            step++; // 步数加1
        }
        return -1;
    }

    // 往上拨动
    static String upOne(String s, int i){
        char[] chars = s.toCharArray();
        if (chars[i] == '9'){
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    // 往下拨动
    static String downOne(String s, int i){
        char[] chars = s.toCharArray();
        if (chars[i] == '0'){
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
