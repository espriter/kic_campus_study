package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostData")
public class PostData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post 방식 내보내기
		response.setContentType("text/html;charset=utf-8"); // post 방식 내보내기
		String name = request.getParameter("name"); //뒤의 name은 name,addr 등
		//System.out.println(name);
		
		// 동일한 이름의 파라미터가 복수의 경우에는 배열 처리
		String addr[] = request.getParameterValues("addr");
		//System.out.println(addr[0] + " " + addr[1] );
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>post</title></head></html>");
		writer.println("<body><h2>결과확인(post)</h2><br>");
		writer.println("이름은 " + name + "입니다<br>");
		writer.println("주소 " + addr[0] + " " + addr[1] + "입니다<br>");

		//checkbox 받기
		try {
			String langs[] = request.getParameterValues("Lang");
			writer.println("선택한 언어는");
						
			for(String v:langs) {
				writer.println(v + " ");
			}
			
		} catch (Exception e) {
			writer.println("<b>하나 이상의 언어를 선택하시오</b>");
			return;
		}
		// checkbox 종료

		// radio 버튼 받기
		String os = request.getParameter("os");
		writer.println("<br>교통수단은 " + os + "입니다"	);
		// radio 버튼 종료
		
		// 셀렉트 내용 받기
		String tr = request.getParameter("tr");
		writer.println("<br>교통수단은 " + tr + "입니다"	);
		// 셀렉트 내용 종료
		
		// 히든 hidden
		String etc = request.getParameter("etc");
		writer.println("<br><b>히든값은</b> " + etc + "<b>입니다</b>"	);
		// 셀렉트 내용 종료
		
		writer.println("</body></html>");
		writer.close();
		
	}

}
