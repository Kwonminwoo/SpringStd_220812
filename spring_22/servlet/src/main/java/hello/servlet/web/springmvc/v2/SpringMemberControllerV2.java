package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members") // request매핑의 앞부분을 공통으로 묶을 수 있음.
public class SpringMemberControllerV2 {
    // 메소드별로 매핑이 되므로 한 클래스에 넣을 수 있음 (메소드 이름은 다르게)
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // /springmvc/v2/members/ + /new-form
    @RequestMapping("/new-form") // 매핑 정보임. 아래 메소드가 실행됨 매핑되면
    public ModelAndView newForm(){
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response){ // request, responseㅍ 사용 가능
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member); // mv.getModel().put()과 같음
        return mv;
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);

        return mv;
    }
}
