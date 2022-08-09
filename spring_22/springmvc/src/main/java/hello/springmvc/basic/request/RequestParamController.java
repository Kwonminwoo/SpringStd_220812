package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);
        response.getWriter().write("ok");
    }


    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, // 파라미터와 이름이 같으면 생략 가능
            @RequestParam int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){ // 파라미터 이름이 같고 단순 타입이면 RequestParam 아예 생략 가능
        log.info("username={}, age={}", username, age);
        return "ok";
    }


    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, // required=true면 필수 파라미터, 안 넘어오면 오류, 기본은  true
            @RequestParam(required = false) Integer age){ // 값이 안 넘어오면 null인데 기본 자료형인 int에는 null이 들어갈 수 없기에 Integer로 해야함
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, // 값이 안들어와도 오류가 발생 x default를 쓰면 required가 필요x
            @RequestParam(required = false, defaultValue = "-1") int age){ // 기본값을 설정
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody // RestController 붙인거랑 같은 동작이 됨
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){ // map으로 전체를 받음
        String username = (String) paramMap.get("username");
        int age = (int) paramMap.get("age");
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        // HelloData의 프로퍼티(getter, setter)를 찾고 setter를 호출해서 파라미터값을 입력함.
        log.info("helloData={}", helloData);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){ // ModelAttribute 생략가능 단순 타입 외에는 ModelAttribute로 자동 처리
        log.info("helloData={}", helloData);
        return "ok";
    }


}
