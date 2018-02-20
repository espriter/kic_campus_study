package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLogin")
public class CookieLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키가 없는 경우 로그인 화면 출력, 있다면 바로 메시지 출력
		String id = null;
		String pwd = null;
		try {
			Cookie[] cookies = request.getCookies(); // 클라이언트에 모든 쿠키를 읽게 됨
			for (int i = 0; i < cookies.length; i++) {
				String name = cookies[i].getName();
				System.out.println(name);
				if(name.equals("id")) {
					id = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
				if(name.equals("pwd")) {
					pwd = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				}
				
			}
			if(id != null && pwd !=null) {
				out.println("<html><body>");
				out.println(id + "님 쿠키 통해서 로긴");
				out.println("</body></html>");
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		out.println("<html><body>");
		out.println("** 로그인 **");
		out.println("<form method='post'>");
		out.println("i d : <input type='text' name='id'><br>");
		out.println("pwd : <input type='text' name='pwd'><br>");
		out.println("<input type='submit' value='전송'>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("성공");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		out.println("<html><body>");
		if(id.equals("aa") && pwd.equals("11")) {
		out.println("로그인 성공");
			try {
				id = URLEncoder.encode(id, "utf-8"); //암호화
				Cookie idCookie = new Cookie("id", id);
				idCookie.setMaxAge(60 * 60 * 24 * 365); // 유효기간 1년
				
				pwd = URLEncoder.encode(id, "utf-8"); //암호화
				Cookie pwdCookie = new Cookie("id", id);
				pwdCookie.setMaxAge(60 * 60 * 24 * 365); // 유효기간 1년
				
				response.addCookie(idCookie); // 클라이언트 컴에 저장
				response.addCookie(pwdCookie); // 클라이언트 컴에 저장
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		}else {
			out.println("로그인 실패");
					}
		out.println("</body></html>");
		out.close();
	}

}
	