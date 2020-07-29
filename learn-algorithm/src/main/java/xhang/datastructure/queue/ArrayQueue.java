package xhang.datastructure.queue;

/**
 * @Author xhang
 * 使用数组模拟一个队列
 * 有效数据的个数：(rear + maxSize - front) % maxsize
 * Date 2020/2/13
 **/
public class ArrayQueue {

    private int maxSize;//数组的最大容量
    private int front;//队列头部,指向队列的头部，包含第一个数据
    private int rear;//队列尾部,指向队列的尾部，最后一个数据的后一个位置
    private int[] arr;//存放队列的数据

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满：尾部指向数组最大长度减一时满
     * @return
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空：首部等于尾部是为空
     * @return
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据到队列中
     * @param data
     */
    public void addQueue(int data){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        arr[rear] = data;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取出数据
     * @return
     */
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能取数据");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }
}
