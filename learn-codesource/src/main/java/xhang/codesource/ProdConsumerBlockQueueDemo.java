package xhang.codesource;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xhang
 * Date 2020/6/15
 * 阻塞队列生产者消费者示例代码
 **/
class MyResource{

    // 定义一个标志位，表示是否需要开启生产消费
    private volatile Boolean flag = true;

    // 使用原子引用类，避免在并发情况下出现累加出现问题
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println("当前使用的block是\t" + blockingQueue.getClass().getName());
    }

    // 生产者的方法
    public void myProd() throws Exception{
        String data = null;
        boolean returnValue;
        while (flag){
            data = atomicInteger.incrementAndGet() + "";
            returnValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (returnValue){
                System.out.println(Thread.currentThread().getName()+"\t 插入数据成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入数据失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 停止生产数据了。。。。。。。。");
    }

    // 消费者的方法
    public void myConsumer() throws Exception{
        String result = null;
        while (flag){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || "".equalsIgnoreCase(result)){
                flag = false;
                System.out.println("停止消费了");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 成功消费数据\t"+result);
        }
    }

    public void stop() throws Exception{
        this.flag = false;
    }
}
public class ProdConsumerBlockQueueDemo {

    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();

        System.out.println();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        myResource.stop();
    }
}
