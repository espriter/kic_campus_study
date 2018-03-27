package kr.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.m2")		//<- 둘다있으면 web.xml이 우선순위가 더 높음.
public class UserServlet extends HttpServlet {

	ModelAndView modelAndView = null;
	Controller controller = null;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		try {
			String command = request.getParameter("command"); 
			if(command == null || command.equals("")) {
				command = "list";
			}
			
			controller = getAction(command);
			modelAndView = controller.execute(request, response);
			
			//파일 호출 방식 선택
			if(modelAndView.isRedirect()) {
				response.sendRedirect(modelAndView.getViewName());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(modelAndView.getViewName());
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("service arr : " + e);
		}
		
	}

	public Controller getAction(String command) throws Exception {
		if (command.equals("login")) {
			controller = new LoginAction();
		} else if (command.equals("list")) {		//서블릿을 만나면 클라이언트로 만나서 어찌고,,,그래서 redirect방식으로 해야..
			controller = new ListAction();
		}else if(command.equals("logout")) {
			controller = new LogoutAction();
		}else if(command.equals("insert")) {
			controller = new InsertAction();
		}else if(command.equals("view")) {
			controller = new ViewAction();
		}else if(command.equals("updateform")) {
			controller = new UpdateFormAction();
		}else if(command.equals("update")) {
			controller = new UpdateAction();
		}else if(command.equals("delete")) {
			controller = new DeleteAction();
		}
		return controller;
	}
	
	// forward 서버에서 서버 파일보내는거
	// redirect 클라이언트로 보내는거

}








 