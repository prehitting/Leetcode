package com.prehitting.annotation;

import com.prehitting.enums.Type;
import com.prehitting.enums.Version;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Answer {

    String desc() default "";

    Version version() default Version.Only;

    Type type() default Type.None;

}
