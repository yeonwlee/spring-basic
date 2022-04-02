package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false) // 의존관계가 없으면 이 메서드 자체가 호출이 안 됨
        public void setNoBean1(Member noBean1){ //스프링에서 관리되지 않은 클래스 아무거나 넣은것
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ //스프링에서 관리되지 않은 클래스 아무거나 넣은것
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ //스프링에서 관리되지 않은 클래스 아무거나 넣은것
            System.out.println("noBean3 = " + noBean3);
        }
    }

}
