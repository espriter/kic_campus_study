package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getData")
public class getData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String nai = request.getParameter("age");
		//System.out.println(name);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>get</title></head></html>");
		writer.println("<body>");
		writer.println("이름은 " + name + "<br>");
		writer.println("주소는 " + addr + "<br>");
		//writer.println("나이는 " + nai + "<br>");
		
		String new_nai = calcNai(nai);
		writer.println("나이는 " + new_nai + "<br>");
		
		writer.println("<a href='abc/getdata.html'>다시입력</a>");		
		writer.println("</body>");
		writer.println("</html>");
		writer.close();
	}
	
	private String calcNai(String age) { // 메소드
		int imsi = Integer.parseInt(age) / 10 * 10;
		String re = null;
		switch (imsi) {
		case 20:
			re = "이십대";
			break;
		case 30:
			re = "삼십대";
			break;
		default:
			re = "기타";
			break;
		}
		return re;
	}

}
