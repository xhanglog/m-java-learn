package xhang.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author xhang
 * Date 2020/5/16
 * 面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 **/
public class MaxQueue {

    Queue<Integer> que;
    Deque<Integer> maxq;

    public MaxQueue() {
        que = new LinkedList<>();  //队列：插入和删除
        maxq = new LinkedList<>();  //双端队列：获取最大值
    }

    public int max_value() {
        return maxq.size() > 0 ? maxq.peek() : -1;
    }

    public void push_back(int value) {
        que.offer(value);  //value入队
        while (maxq.size() > 0 && maxq.peekLast() < value) {
            maxq.pollLast();  //将maxq队尾小于value的元素删掉
        }
        maxq.offerLast(value);  //将value放在maxq队尾

    }

    public int pop_front() {
        int tmp = que.size() > 0 ? que.poll() : -1;  //获得队首元素
        if (maxq.size() > 0 && maxq.peek().equals(tmp)) {
            maxq.poll();  //如果出队的元素是当前最大值，将maxq的队首出队
        }
        return tmp;
    }
}
