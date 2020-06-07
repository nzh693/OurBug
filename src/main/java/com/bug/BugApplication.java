package com.bug;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * JDK 1.8
 *
 */

@SpringBootApplication
@ComponentScan(value = {"com"})
public class BugApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugApplication.class, args);
    }

}
