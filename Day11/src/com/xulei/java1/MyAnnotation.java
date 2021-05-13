package com.xulei.java1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xl
 * @ClassName: MyAnnotation
 * @Description:
 * @date: 2021-05-13 15:01
 * @since JDK 1.8
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
        String value() default "hello";
}
