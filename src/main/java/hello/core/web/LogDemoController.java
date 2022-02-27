package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.web.LogDemoSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoSevice logDemoSevice;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody//문자를 그대로 보낼 수 있음
    public String logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = "+ myLogger.getClass() );

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoSevice.logic("testId");
        return "Ok";
    }
}