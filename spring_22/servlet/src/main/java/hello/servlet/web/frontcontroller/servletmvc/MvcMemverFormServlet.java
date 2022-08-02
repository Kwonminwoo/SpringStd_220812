package hello.servlet.web.frontcontroller.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// controler역할
// mvc패턴은 항상 controler를 거쳐 view로 간다
@WebServlet(name = "mvcMemverFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemverFormServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; // 뷰의 경로
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 컨트롤러에서 뷰로 이동할 때 필요한 객체1
        dispatcher.forward(request, response); // 컨트롤러에서 뷰로 넘어가는 메소드
    }
}
