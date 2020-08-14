package xhang.spring;

/**
 * @Author xhang
 * bean 的一些配置定义信息
 **/
public class BeanDefinition {

    private String scope; // 作用域，单例还是原型
    private Class beanClass;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
