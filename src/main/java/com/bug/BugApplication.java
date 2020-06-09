package com.bug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * JDK 1.8
 *
 */

@SpringBootApplication
@MapperScan("com.bug.mapper")
@CrossOrigin
public class BugApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugApplication.class, args);
    }

}
