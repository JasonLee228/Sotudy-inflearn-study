package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
    // 기존에 class 에 직접 @Qualifier("mainDiscountPolicy") 를 붙여서 같은 타입의 빈이 여러개일 경우를 대비해 우선권을 쥐어줬지만,
    // 문자열로 빈을 직접 지정해 오류가 날 확률이 있기 때문에 어노테이션을 직접 만들어 mainDiscountPolicy 오기를 방지할 수 있다.
}
