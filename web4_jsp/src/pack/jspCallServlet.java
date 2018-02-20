package pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jspCallServlet
 */
@WebServlet("/irum.go")
public class jspCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");
		// 넘어온 자료로 이런저런 일 하다가...
		
		// 파일 호출 1 : redirect - client를 통해 server 파일 호출
		//response.sendRedirect("jspcall1.jsp");
		//response.sendRedirect("jspcall1.jsp?data=" + data);
		
		
		// 파일 호출 2 : forward - server에서 바로 server 파일 호출
		//RequestDispatcher dispatcher =
		//request.getRequestDispatcher("jspcall1.jsp?data=" + data);
		//dispatcher.forward(request, response);

		// 파일 호출2의 2줄을 한줄로 작성 가능
		// request.getRequestDispatcher("jspcall1.jsp").forward(request,response);
		
		request.setAttribute("test", data);
		request.getRequestDispatcher("jspcall1.jsp").forward(request,response);
		
	}

}
