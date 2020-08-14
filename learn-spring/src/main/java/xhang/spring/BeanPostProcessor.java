package xhang.spring;

/**
 * @Author xhang
 * bean 的处理器
 **/
public interface BeanPostProcessor {

    /**
     * 初始化前
     * @param bean 对象bean
     * @param beanName bean的名称
     * @return
     */
    Object postProcessorBeforeInitialization(Object bean, String beanName);

    /**
     * 初始化后
     * @param bean 对象bean
     * @param beanName bean的名称
     * @return
     */
    Object postProcessorAfterInitialization(Object bean, String beanName);
}
