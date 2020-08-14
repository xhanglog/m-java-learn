package xhang.spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * scope 注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {

    String value() default "singleton";
}
