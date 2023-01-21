package com.prehitting.annotation;

import com.prehitting.enums.Level;
import com.prehitting.enums.Type;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
public @interface Question {

    String title() default "";

    Type[] tags() default Type.None;


    Level level() default Level.SIMPLE;

    String desc() default "";

}
