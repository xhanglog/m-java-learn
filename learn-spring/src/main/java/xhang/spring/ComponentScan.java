package xhang.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author xhang
 * 自定义扫描类
 **/
@Retention(RetentionPolicy.RUNTIME) // 运行时
@Target(ElementType.TYPE) // 只能用在类上面
public @interface ComponentScan {

    String value() default "";
}
