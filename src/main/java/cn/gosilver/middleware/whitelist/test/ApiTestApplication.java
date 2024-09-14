package cn.gosilver.middleware.whitelist.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Author: chensh
 * Date: 2024/9/14 3:10 PM
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.gosilver.middleware.*"})
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

}

