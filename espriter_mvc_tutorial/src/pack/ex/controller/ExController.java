package pack.ex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.ex.model.GugudanModel;
import pack.ex.model.SuModel;

/**
 * Servlet implementation class ExController
 */
@WebServlet("*.do")
public class ExController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	GugudanModel gumodel = null;
	SuModel sumodel = null;
	
	@Override
	public void init() throws ServletException {
		gumodel= new GugudanModel();
		sumodel= new SuModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String su = request.getParameter("su");
		String dan =request.getParameter("dan");
		String result = null;
		
		if(su != null) {
			result = sumodel.getSuResult(su);
		}else if(dan != null) {
			result = gumodel.getGuResult(dan);
		}
	
		request.setAttribute("result", result);
		String viewName = "view/result.jsp";
		
		request.getRequestDispatcher(viewName).forward(request, response);
	}
}
