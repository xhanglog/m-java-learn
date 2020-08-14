package xhang.test.service;

import xhang.spring.BeanPostProcessor;
import xhang.spring.Component;

/**
 * @Author xhang
 **/

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前。。。。。。。。\t"+beanName);
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后。。。。。。。。\t"+beanName);
        return bean;
    }
}
