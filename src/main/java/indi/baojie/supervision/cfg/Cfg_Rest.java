package indi.baojie.supervision.cfg;

/**
 * Created by Lollipop on 2017/7/25.
 */

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.activiti.rest")
@EnableWebMvc
public class Cfg_Rest {

    @Bean
    public ServletRegistrationBean restServlet(){
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan("com.jerryl.rest");
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet rest_dispatcherServlet
                = new DispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
        registrationBean.addUrlMappings("/service/*");
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("rest");
        return registrationBean;
    }
}
