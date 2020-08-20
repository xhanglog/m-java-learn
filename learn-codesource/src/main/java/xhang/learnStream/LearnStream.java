package xhang.learnStream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author xhang
 * 请按照给出数据，找出同时满足偶数ID且年龄大于24且用户名转为大写且用户名字母倒排序最后只输出一个用户名字。
 **/

public class LearnStream {

    public static void main(String[] args) {

        User u1 = new User(11,"a",23);
        User u2 = new User(12,"b",24);
        User u3 = new User(13,"c",22);
        User u4 = new User(14,"d",28);
        User u5 = new User(16,"e",26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);

        /**
         * filter 里边是filter(Predicate<? super T> predicate) 判定型接口
         *
         * map map(Function<? super T, ? extends R> mapper) 函数型接口
         *
         * sorted sorted(Comparator<? super T> comparator) 函数型接口，比较器
         */
        list.stream().filter(p->{return p.getId() %2 == 0;}) // 筛选偶数ID
                .filter(p->{return p.getAge() > 24;}) //筛选年龄大于24
                .map(u->{return u.getUserName().toUpperCase();}) // 户名转为大写
                .sorted((t1,t2)->{return t2.compareTo(t1);}) // 倒序排序
                .limit(1) // 获取一个数据
                .forEach(System.out::println);
    }
}



