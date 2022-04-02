package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.security.Signature;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingltonBean.class);// 이 파리미터는 컴포넌트 클래스를 넣어주는 것. 자동으로 컴포넌트 스캔
        SingltonBean singletonBean = ac.getBean(SingltonBean.class);
        SingltonBean singletonBean2 = ac.getBean(SingltonBean.class);
        System.out.println("singletonBean = " + singletonBean);
        System.out.println("singletonBean2 = " + singletonBean2);

        assertThat(singletonBean).isSameAs(singletonBean2); //isSameAs == 비교
        ac.close(); //종료
    }

    @Scope("singleton")
    static class SingltonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingltonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingltonBean.destroy");
        }
    }
}
