package com.bug;

import com.bug.service.IBuyProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

@SpringBootTest
@WebAppConfiguration
class BugApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(LocalDateTime.now());
    }

    @Autowired
    private IBuyProductService buyProductService;

    @Test
    public void testTime(){
        buyProductService.Maketime(10);
        buyProductService.Maketime(1);
        buyProductService.Maketime(3);
        buyProductService.Maketime(6);
        buyProductService.Maketime(5);
    }






}
