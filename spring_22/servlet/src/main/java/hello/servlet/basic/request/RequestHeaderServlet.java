package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartline(request);
        printHeaders(request);
        printHeaderUtils(request);
    }

    private void printStartline(HttpServletRequest request){
        System.out.println("start line print");
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); // https인가 아닌가
        System.out.println();
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("Header print");
        request.getHeaderNames().asIterator().forEachRemaining
                (headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println();
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request){
        System.out.println("Host 편의 조회");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());

        System.out.println("Accept Language 편의 조회");
    request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + request.getLocale()); // 가장 순위가 높은 것
        System.out.println();
        System.out.println("쿠키 조회");
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("Content 조회");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println();
        System.out.println();
    }
}
