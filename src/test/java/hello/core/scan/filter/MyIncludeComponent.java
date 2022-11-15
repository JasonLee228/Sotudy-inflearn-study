package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // 이 어노테이션이 붙은 것을 컴포넌트로 인식시키도록 할 것임.
}
