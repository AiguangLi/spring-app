package com.lios.study.app.config;

/**
 * @author liaiguang
 * @date 2020/8/16
 */
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Druid配置类
 *
 * @author lemon
 */
@Configuration
public class DruidConfiguration {

    @Value("${spring.datasource.druid.stat-view-servlet.login-username}")
    private String loginUserName;

    @Value("${spring.datasource.druid.stat-view-servlet.login-password}")
    private String loginPassword;

    @Value("${spring.datasource.druid.stat-view-servlet.allow}")
    private String allow;

    @Value("${spring.datasource.druid.stat-view-servlet.deny}")
    private String deny;

//    @Bean(name = "druidDataSource",destroyMethod = "close",initMethod = "init")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }

    /**
     * 配置监控服务器
     *
     * @return 返回监控注册的servlet对象
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 添加IP白名单
        servletRegistrationBean.addInitParameter("allow", this.allow);
        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
        servletRegistrationBean.addInitParameter("deny", this.deny);
        // 添加控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", this.loginUserName);
        servletRegistrationBean.addInitParameter("loginPassword", this.loginPassword);
        // 是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 配置服务过滤器
     *
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤格式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

//    @Bean(name="dataSource")
//    public DataSource dataSource(){
//        return new DruidDataSource();
//    }

    /**
     * 配置事物管理器
     * @return 返回事务管理器
     */
//    @Bean(name="transactionManager")
//    public DataSourceTransactionManager transactionManager(){
//        return new DataSourceTransactionManager(dataSource());
//    }
}