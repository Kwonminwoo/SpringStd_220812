package hello.springmvc.basic.response;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ResponseViewController {
    // ModelAndView 반환
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("/response/hello").addObject("data", "hello!");
        return mav;


    }

    // String 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data", "hello!");
        return "/response/hello"; // view 경로 매핑
    }

    // void 반환 (권장하지 않음) 명시성이 너무 떨어짐..
    @RequestMapping("/response/hello") // 매핑 경로와 같으면 생략 가능
    public void responseViewV3(Model model){
        model.addAttribute("data", "hello!");
    }


}
