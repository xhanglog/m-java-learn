package xhang.codesource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author xhang
 * Date 2020/8/7
 * 读写锁,只允许一个线程进行写的操作，可以同时读取数据
 *
 **/
class MyCache {

    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    //写入
    public void put(String key,Object value){
        reentrantReadWriteLock.writeLock().lock();
        try {
            try {
                System.out.println(Thread.currentThread().getName()+"\t开始写入\t"+key);
                //模拟网络波动，延时300ms
                TimeUnit.MICROSECONDS.sleep(300);
                map.put(key,value);
                System.out.println(Thread.currentThread().getName()+"\t写入完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        reentrantReadWriteLock.readLock().lock();
        try{
            try {
                System.out.println(Thread.currentThread().getName()+"\t开始读取");
                //模拟网络波动，延时300ms
                TimeUnit.MICROSECONDS.sleep(300);
                Object res = map.get(key);
                System.out.println(Thread.currentThread().getName()+"\t读取完成\t"+res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }catch (Exception e){e.printStackTrace();}
        finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //写入
        for(int i=1;i<6;i++){
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp);
            },String.valueOf(i)).start();
        }

        //读取
        for(int i=1;i<6;i++){
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
