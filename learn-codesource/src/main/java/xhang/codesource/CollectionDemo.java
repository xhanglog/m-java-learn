package xhang.codesource;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xhang
 *  集合源码详解,基于JDK8
 *  - List
 *      - ArrayList 线程不安全，底层数组实现
 *      - LinkedList 线程不安全，底层链表实现
 *      - Vector 线程安全
 *  - Set 不允许元素重复
 *      - HashSet 线程不安全。底层实现 HashMap
 *          - LinkedHashSet
 *      -
 *      - TreeSet
 *  - Map
 *      - HashMap
 *          - LinkedHashMap
 *      - Hashtable
 *      - TreeMap
 *      - ConcurrentHashMap 属于JUC包
 **/
public class CollectionDemo {

    public static void listDemo(){
        /**
         * - 底层实现为数组
         * - 初始容量为 0，第一次添加元素的时候赋予长度为默认值 10，jdk1.7创建集合时便初始化容量
         * - 添加元素时，首先通过 ensureCapacityInternal 方法对数组容量进行初始化；
         *   如果当前数组的长度小于修改后的数组长度，则需要通过 grow方法对数组进行扩容；
         *   通过 int newCapacity = oldCapacity + (oldCapacity >> 1)对数组扩容，扩大为原来的 1.5倍；
         *   如果新容量 newCapacity大于 MAX_ARRAY_SIZE (Integer.MAX_VALUE - 8)，则使用 hugeCapacity
         *   方法对数组长度进行再次判断，赋予容量为 MAX_ARRAY_SIZE 或者 Integer.MAX_VALUE；
         *   使用 copyOf函数将旧数组元素复制到新的数组;
         *
         * - clear 方法将数组元素置为空，然后数组长度改为 0
         */
        List arrayList = new ArrayList<>();

        /**
         * - 底层实现为双向链表
         */
        List linkedList = new LinkedList<>();

        /**
         * - 底层为数组，创建时便赋予容量，默认为10
         * - 公共方法添加了 synchronized关键字，线程安全
         * - 扩容 int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity)
         * 如果定义了 capacityIncrement的值，每次扩容大小为原来的容量加上 capacityIncrement的大小，否则扩容为原来的 2倍
         */
        List vector = new Vector<>();
    }

    public static void mapDemo(){
        /**
         *
         */
        Map<Object, Object> hashMap = new HashMap<>();
        Map<Object, Object> hashtable = new Hashtable<>();
        Map<Object, Object> treeMap = new TreeMap<>();
        Map<Object, Object> linkedHashMap = new LinkedHashMap<>();

        Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }

    public static void setDemo(){

        /**
         * - 底层实现为 HashMap，初始容量为 16，加载因子为 0.75
         * - map.put(e, PRESENT)==null 添加方法有一个是添加到 key上面，value默认为一个 object常量
         */
        Set hashSet = new HashSet<>();

        /**
         * - 继承自 HashSet,初始容量为 16，加载因子为 0.75；
         * - 最底层使用 LinkedHashMap实现，保证了元素的顺序
         */
        Set linkedHashSet = new LinkedHashSet<>();
        Set treeSet = new TreeSet<>();
    }

}
