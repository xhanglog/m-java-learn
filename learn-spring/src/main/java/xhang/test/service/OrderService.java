package xhang.test.service;

import xhang.spring.*;

/**
 * @Author xhang
 **/
@Component("orderService")
@Scope("prototype")
public class OrderService implements InitializingBean, BeanNameAware {

    @Autowired
    private Userservice userService;

    private String beanName;

    public void print(){
        System.out.println(userService + "\t" + beanName);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化方法");
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
