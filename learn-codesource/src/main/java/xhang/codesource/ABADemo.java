package xhang.codesource;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Description: ABA问题的解决
 *
 * @author veliger@163.com
 * @date 2019-04-12 21:30
 **/
public class ABADemo {
    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + "，版本号为" + stamp + "，值是" + stampedReference.getReference());
            //暂停1秒钟t1线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stampedReference.compareAndSet(100, 101, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + "，版本号为" + stampedReference.getStamp() + "，值是" + stampedReference.getReference());
            stampedReference.compareAndSet(101, 100, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + "，版本号为" + stampedReference.getStamp() + "，值是" + stampedReference.getReference());
            System.out.println("线程t1已完成1次ABA操作~~~~~");
        }, "t1").start();

        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + "，版本号为" + stamp + "，值是" + stampedReference.getReference());
            //线程2暂停3秒，保证线程1完成1次ABA
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = stampedReference.compareAndSet(100, 6666, stamp, stamp + 1);
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + "，修改成功否：" + result + "，最新版本号" +
                    stampedReference.getStamp() + "，最新的值：" + stampedReference.getReference());
        }, "t2").start();
    }
}


