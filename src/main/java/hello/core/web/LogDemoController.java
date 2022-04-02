package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider; //MyLogger가 아닌 MyLogger를 찾을 수 있는 녀석이 주입됨
    private final MyLogger myLogger; //마치 싱글톤으로 주입된 것 같지만 가짜객체가 매번 생성되고 있음

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        System.out.println("myLogger = " + myLogger.getClass()); //가짜 myLogger를 우선 주입해서 다른 클래스가 나옴
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");

        return "OK";
    }
}
