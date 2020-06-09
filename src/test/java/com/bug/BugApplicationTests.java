package com.bug;

import com.bug.enums.ServiceType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
class BugApplicationTests {

    @Test
    void contextLoads() {
//        new MyTest().test();
//        MyTest t;
//        t = new MyTest();
//        t.test();

        System.out.println(ServiceType.CONSULT.getValue());
    }






}
