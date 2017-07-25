package indi.baojie;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import java.io.IOException;

/**
 * Created by Lollipop on 2017/6/15.
 */
@SpringBootApplication()
@EnableAutoConfiguration(exclude={SecurityAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
