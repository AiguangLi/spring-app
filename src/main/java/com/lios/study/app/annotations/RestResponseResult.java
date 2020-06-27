package com.lios.study.app.annotations;

import java.lang.annotation.*;

/**
 * @author liaiguang
 * @date 2020-06-12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface RestResponseResult {

}
