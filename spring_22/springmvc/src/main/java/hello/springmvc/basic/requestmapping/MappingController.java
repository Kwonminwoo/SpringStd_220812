package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/hello-basic", "hello-go"}) // 두개 매핑해도 됨
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/hello-get")
    public String helloGet(){
        return "ok";
    }

    /**
     * PathVariable(경로 변수) 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA 이런식으로 오면 매핑
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable("orderId") String order){
        // PathVariable과 똑같이 사용한다면 위처럼 할 수 있음.
        log.info("mappingPath userId={}, orderId={}", userId, order);
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = MediaType.TEXT_PLAIN_VALUE) // Content-Type 지정
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_PLAIN_VALUE) // text/html 쓴것과 같음
    // Accept 지정 Accept가 text/html일때만 매핑되게
    public String mappingProduces(){
        log.info("mappingProduces");
        return "ok";
    }

}
