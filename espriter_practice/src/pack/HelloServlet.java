package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet.java")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 요청에 대한 처리 메소드
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println("호출당함"); // 이건 브라우저가 아닌 콘솔에 찍힘

		PrintWriter out = response.getWriter();  //클라이언트 브라우저로 출력
		out.println("<html><body>");
		//----------------------------------
		out.println("<h1> 서블렛 만세</h1>");
		out.println("나의 <b>홈피</b> 입니다");
		//----------------------------------
		out.println("</html></body>");
		
		out.close();
	}

}
