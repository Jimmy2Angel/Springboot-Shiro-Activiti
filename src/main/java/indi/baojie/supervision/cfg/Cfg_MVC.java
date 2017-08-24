package indi.baojie.supervision.cfg;

import com.alibaba.fastjson.parser.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

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

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        fastJsonConfig.setFeatures(Feature.IgnoreNotMatch);
//
//        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter4 = new FastJsonHttpMessageConverter4();
//        fastJsonHttpMessageConverter4.setFastJsonConfig(fastJsonConfig);
//        fastJsonHttpMessageConverter4.setSupportedMediaTypes(new ArrayList<MediaType>() {
//            {
//                add(MediaType.TEXT_HTML);
//                add(MediaType.APPLICATION_JSON_UTF8);
//            }
//
//        });
//        converters.add(fastJsonHttpMessageConverter4);
//    }

}
