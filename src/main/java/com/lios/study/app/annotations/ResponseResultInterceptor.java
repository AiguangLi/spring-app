package com.lios.study.app.annotations;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author liaiguang
 * @date 2020/6/12
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    /**
     * 标记名称
     */
    public static final String RESPONSE_RESULT_ANNOTATION = "RESPONSE_RESULT_ANNOTATION";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //对象加了RestResponseResult注解
            if (clazz.isAnnotationPresent(RestResponseResult.class)) {
                //设置请求的返回体需要包装，在ResponseBodyAdvice接口进行判断
                Logger.logMsg(Logger.INFO, "RestResponseResult类注解");
                request.setAttribute(RESPONSE_RESULT_ANNOTATION, clazz.getAnnotation(RestResponseResult.class));
            } else if (method.isAnnotationPresent(RestResponseResult.class)) {
                Logger.logMsg(Logger.INFO, "RestResponseResult方法注解");
                request.setAttribute(RESPONSE_RESULT_ANNOTATION, clazz.getAnnotation(RestResponseResult.class));
            }
        }
        return true;
    }
}