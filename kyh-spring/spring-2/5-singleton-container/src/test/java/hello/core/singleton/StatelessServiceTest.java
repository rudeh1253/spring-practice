package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatelessServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatelessServiceTest.TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // ThreadA: A 사용자 10000원 주문
        int price1 = statelessService1.order("userA", 10000);
        // ThreadB: B 사용자 20000원 주문
        int price2 = statelessService2.order("userB", 20000);

        assertEquals(10000, price1); // 테스트 성공!
    }

    static class TestConfig {

        @Bean
        public StatelessService statefulService() {
            return new StatelessService();
        }
    }
}