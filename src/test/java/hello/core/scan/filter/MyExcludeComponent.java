package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    // 이 어노테이션이 붙은 것을 컴포넌트 스캔에서 제외하도록 할 것임.
}
