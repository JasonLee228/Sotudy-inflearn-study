package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
/*
* TODO: 컴포넌트 스캔을 통한 빈 등록
* */
@Configuration
@ComponentScan( // 스캔 대상에서 제외할 항목 선택, @Configuration 은 자동으로 빈으로 올라가선 안되기 때문에(기존 코드 때문) 제외 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // @Bean 으로 뭔가 설정한게 없다!
}
