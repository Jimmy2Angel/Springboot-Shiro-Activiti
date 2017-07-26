package indi.baojie.supervision.cfg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * Created by Shawn on 2017/6/1.
 */
@EnableWebMvc
@ComponentScan(
        basePackages = "indi.baojie.supervision.controller"
)
@Configuration
public class Cfg_MVC extends WebMvcConfigurerAdapter {

    private Logger logger = LogManager.getLogger(this);

    public Cfg_MVC() {
        logger.info("********************* WebMvcConfig init ... *********************");
    }


    @Bean("multipartResolver")
    public CommonsMultipartResolver getMultipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(20 * 1024 * 1024);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setPrefix("/WEB-INF/views/");
        jspViewResolver.setSuffix(".jsp");

        // jsp 用到的全局变量
        try {
            HashMap<String, Object> jspVars = new LinkedHashMap<>();
            Properties vars = new Properties();
            vars.load(new InputStreamReader(getClass().getResourceAsStream("/jsp-vars.properties"), "UTF-8"));
            Enumeration<String> varsEnum = (Enumeration<String>) vars.propertyNames();
            while (varsEnum.hasMoreElements()) {
                String k = varsEnum.nextElement();
                String v = vars.getProperty(k);
                jspVars.put(k, v);
                if (logger.isDebugEnabled()) {
                    logger.debug("{}:{}", k, v);
                }
            }
            jspViewResolver.setAttributesMap(jspVars);
        } catch (IOException e) {
            logger.error(e);
        }

        registry.viewResolver(jspViewResolver);
    }

}
