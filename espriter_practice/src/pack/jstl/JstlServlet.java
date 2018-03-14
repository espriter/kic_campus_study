package pack.jstl;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Person person = null;

	@Override
	public void init() throws ServletException {
		person = new Person();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String irum = "마당쇠";
		request.setAttribute("man", irum);

		person.setName("한국인");
		person.setAge(33);
		request.setAttribute("person", person);

		// 문자열 배열
		String[] animals = { "호랑이", "사자", "치타" };
		request.setAttribute("animals", animals);

		// Collection
		String[] foods = { "고기", "생선", "밥" };
		java.util.List<Object> list = new ArrayList<>();
		list.add(foods);
		request.setAttribute("list", list);

		request.getRequestDispatcher("jstl6.jsp").forward(request, response);
	}

}
