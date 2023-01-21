package com.prehitting.annotation;

import com.prehitting.enums.Version;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Assist {

    Version version() default Version.Only;

}
