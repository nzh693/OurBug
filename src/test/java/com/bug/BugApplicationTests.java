package com.bug;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;

@SpringBootTest
@WebAppConfiguration
class BugApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now());
    }






}
