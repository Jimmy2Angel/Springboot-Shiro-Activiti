package indi.baojie.supervision.config;

/**
 * Created by Lollipop on 2017/7/25.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("org.activiti.rest")
@EnableWebMvc
public class RestConfig {
}
