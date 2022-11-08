package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread-A : A 사용자 10000원 주문
        statefulService1.order("A", 10000);

        // Thread-B : B 사용자 20000원 주문
        statefulService2.order("B", 20000);

        // Thread-A : A 사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        // statefulService1 에서 주문을 한 A의 주문에 대해서
        // 예상대로라면 A 사용자의 주문 금액은 10000원이 나와야 한다. 하지만 결과는 20000
        // -> statefulService1 == statefulService2 이기 때문.
        System.out.println("price = " + price);

//        assertThat(statefulService1.getPrice()).isEqualTo(10000); // -> 테스트가 실패하게 된다.
        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}