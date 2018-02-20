package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GoServlet")
public class GoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyClass my;
		
	public void init(ServletConfig config) throws ServletException {
		// 요청시 처음 1회만 수행
		my = new MyClass();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get post 둘 다 처리
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>서블릿</title></head></html>");
		writer.println("<body><h1>서블릿의 이해</h1>");
		
		int a = 10;
		int b = 20;
		int c = a / b;
		writer.println("a:" + a + ", b:" + b + ", 더하기:" + c);
		
		int result = calc(a, b);
		writer.println("<br>result : " + result);
		
		Calendar calendar = Calendar.getInstance();
		writer.println("년도는" + calendar.get(Calendar.YEAR));
		
		//MyClass myClass = new MyClass(); 클라이언트 수만큼 객체가 생성되어버림
		
		writer.println("<br>이름은" + my.getIrum());
		my.showData(3, writer);
		writer.println("</body></html>");
		writer.close();
		}
	
		private int calc(int arg1, int arg2) {
			return arg1 + arg2;
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get 요청만 처리
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 요청만 처리

	}

}
