package xhang.test;

import xhang.spring.MyApplicationContext;
import xhang.test.service.OrderService;

/**
 * @Author xhang
 **/
public class Test {

    public static void main(String[] args) {

        // 启动sprig
        MyApplicationContext context = new MyApplicationContext(AppConfig.class);
        // getBean()
       /* OrderService orderService = (OrderService)context.getBean("orderService");

        System.out.println("====================测试属性注入==============");
        orderService.print();

        System.out.println("==============测试单例======================");
        System.out.println(context.getBean("userService"));
        System.out.println(context.getBean("userService"));
        System.out.println(context.getBean("userService"));

        System.out.println("==============测试原型======================");
        System.out.println(context.getBean("orderService"));
        System.out.println(context.getBean("orderService"));
        System.out.println(context.getBean("orderService"));*/

        System.out.println(context.getBean("orderService"));
    }
}
