package indi.baojie.supervision.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lollipop
 */
@Configuration
@ComponentScan("org.activiti.rest")
@EnableWebMvc
public class RestConfig {
}
