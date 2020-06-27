package com.lios.study.app.config;

import com.lios.study.app.models.User;
import com.lios.study.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author liaiguang
 * @date 2020/6/15
 */
@Configuration
public class RouterFunctionConfiguration {
    /**
     * Servlet
     * 请求接口：ServletRequest或HttpServletRequest
     * 响应接口：ServletResponse或HttpServletResponse
     * Spring 5.0重新定义了服务请求和相应接口：
     * 请求接口: ServerRequest
     * 响应接口：ServerResponse
     * 既可以支持Servlet规范，也饿一支持自定义，比如Netty (Web Server)
     * 定义Get请求，并且返回所有的用户对象/user/findAll
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> findAllUser(UserMapper userMapper) {
        return RouterFunctions.route(RequestPredicates.GET("/user/findAll"),
                request-> {
                    List<User> users = userMapper.getUserList();
                    //Mono<ServerResponse> responseMono = null;
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux);
                });
    }
}