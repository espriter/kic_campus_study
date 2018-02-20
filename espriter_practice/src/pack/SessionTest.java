package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 각 클라이언트의 정보를 서버의 메모리에 저장
		HttpSession session = request.getSession(true); // 세션이 있으면 읽고, 없으면 생성
		//HttpSession session = request.getSession(true); // 세션이 있으면 읽고, 없으면 생성 안함
		
		session.setMaxInactiveInterval(60); // 1분간 세션 유효, 기본은 30분
		
		if(session != null) {
			session.setAttribute("name","홍길동");
			session.setAttribute("age","23");
		}			
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("session id : " + session.getId());
		out.println("<br>이름은 : " + session.getAttribute("name"));
		out.println("<br>나이는 : " + session.getAttribute("age"));
		
		out.println("</body></html>");
		out.close();
	}

}
