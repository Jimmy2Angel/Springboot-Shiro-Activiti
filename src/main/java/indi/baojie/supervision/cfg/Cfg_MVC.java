package indi.baojie.supervision.cfg;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Lollipop on 2017/6/1.
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

    /**
     * Configure TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Bean
    @Primary
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);

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
            resolver.setAttributesMap(jspVars);
        } catch (IOException e) {
            logger.error(e);
        }

        resolver.setOrder(1);
        return resolver;
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

        jspViewResolver.setOrder(2);
        registry.viewResolver(jspViewResolver);

//        TilesViewResolver viewResolver = new TilesViewResolver();
//        viewResolver.setOrder(1);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        registry.viewResolver(viewResolver);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        converter.setSupportedMediaTypes(new ArrayList<MediaType>() {
            {
                add(MediaType.APPLICATION_JSON_UTF8);
            }
        });
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

}
