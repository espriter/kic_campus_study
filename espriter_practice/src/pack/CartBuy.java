package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.www.Goods;

@WebServlet("/CartBuy")
public class CartBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 결재 시스템 프로그램은 별도 장착
		// 여기서는 가격의 계를 보여주고 결재했다 가정함
		HttpSession session = request.getSession(false);
		if(session == null) return;
		
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list");
		if(glist == null)return;
		
		// 결재 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		out.println("<br><a href='shop/shop_main.html'>계속 쇼핑</a>");
		int sum = 0;
		for(int i = 0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i);
			out.println("<tr>");
			out.println("<td>" + goods.getName() + "</td>");
			out.println("<tr>");
			sum += goods.getPrice();
		}
		out.println("<tr><td colspan='2'> 결재총액:" + sum + "</tr>");
		
		out.println("</table>");
		out.println("</body></html>");
		
		session.invalidate(); //해당 클라이언트의 세션 내용을 모두 삭제
		
		out.close();

	}
}
