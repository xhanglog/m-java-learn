package xhang.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author xhang
 **/
public class MyApplicationContext {

    private static ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 单例池
    private static ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 处理器集合
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public MyApplicationContext(Class configClass) {

        // 1. 扫描类
        List<Class> classList = scanClass(configClass);
        for (Class clazz : classList) {
            // 判断是否存在Component注解
            if (clazz.isAnnotationPresent(Component.class)) {
                //判断这个clazz是不是实现了 BeanPostProcessor 接口
                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                    try {
                        BeanPostProcessor o = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                        beanPostProcessorList.add(o);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 取出Compoent
                    Component component = (Component) clazz.getAnnotation(Component.class);
                    // 获取bean名称
                    String beanName = component.value();

                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setBeanClass(clazz);
                    // 判断有没有scope注解，有就获取注解的值，没有就默认为单例模式
                    if (clazz.isAnnotationPresent(Scope.class)) {
                        Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                        beanDefinition.setScope(scope.value());
                    } else {
                        beanDefinition.setScope("singleton");
                    }
                    beanDefinitionMap.put(beanName, beanDefinition);
                }
            }
        }

        // 2. 创建非懒加载的单例
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if ("singleton".equals(beanDefinition.getScope())) {
                Object bean = createBean(beanName, beanDefinition);
            }
        }

    }

    /**
     * 创建一个bean
     * @param beanDefinition
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        try {
            // 生成bean
            // - 实例化对象,通过反射实例化对象
            Class beanClass = beanDefinition.getBeanClass();
            Object bean = beanClass.getDeclaredConstructor().newInstance();
            // - 依赖注入，加上autowired的需要自动注入
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)){
                    Object fieldValue = getBean(field.getName());
                    field.setAccessible(true);
                    field.set(bean, fieldValue);
                }
            }
            // - aware 设置bean的一些生成属性，如bean的名称
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }

            // - 初始化前的执行方法
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                bean = beanPostProcessor.postProcessorBeforeInitialization(bean, beanName);
            }

            // - 初始化
            // 判断类是否实现了初始化bean的方法，如果是，则调用其方法
            if (bean instanceof InitializingBean) {
                ((InitializingBean) bean).afterPropertiesSet();
            }

            // - 初始化后的执行方法
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                bean = beanPostProcessor.postProcessorAfterInitialization(bean, beanName);
            }

            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        // 判断实例作用域，单例还是原型
        if ("prototype".equals(beanDefinition.getScope())) {
            Object bean = createBean(beanName, beanDefinition);
            return bean;
        } else {
            // 从单例池里边获取bean
            Object bean = singletonObjects.get(beanName);
            if (bean == null){
                bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
            return bean;
        }
    }

    /**
     * 扫描类
     * @param configClass
     * @return 扫描后获取的类
     */
    private List<Class> scanClass(Class configClass) {

        List<Class> list = new ArrayList<>();

        ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
        // 获取要扫描的类路径值
        String oldPath = componentScan.value();
        // 转换路径格式
        String newPath = oldPath.replace(".", "/");

        ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(newPath);

        File dir = new File(resource.getFile()); // 文件目录
        File[] files = dir.listFiles(); // 获取目录下所有文件,目录下可能还有其它目录，暂考虑目录下全是文件

        for (File file : files) {
            String name = file.getName();
            name = name.substring(0,name.lastIndexOf("."));
            String s = oldPath + "." + name;

            try {
                Class<?> clazz = classLoader.loadClass(s);
                list.add(clazz);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

}
