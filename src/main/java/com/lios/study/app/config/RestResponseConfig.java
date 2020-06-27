package com.lios.study.app.config;

import com.lios.study.app.annotations.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liaiguang
 * @date 2020/6/12
 */
@Configuration
public class RestResponseConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @RestResponseResult 注解 决定是否需要登录
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(AuthorityInterceptor()).addPathPatterns("/**");
    }
}