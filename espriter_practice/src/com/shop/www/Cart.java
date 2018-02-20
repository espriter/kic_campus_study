package com.shop.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니 담기 자료 세션에 저장
		request.setCharacterEncoding("sangname");
		String name = request.getParameter("sangname");
		int price = Integer.parseInt(request.getParameter("price"));
		//System.out.println(name + " " + price);
		
		HttpSession session = request.getSession(true);
		ArrayList<Goods> glist =
		(ArrayList<Goods>) session.getAttribute("list");
		
		if(glist == null) glist = new ArrayList<>();
		glist.add(new Goods(name,price));
		session.setAttribute("list", glist);
		
		// 장바구니의 내용을 화면에 출력하기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("☞" + name + "구입하셨습니다");
		out.println("<br><table width='80%'>");
		
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		out.println("<br><a href='shop/shop_main.html'>계속 쇼핑</a>");
		for(int i = 0; i < glist.size(); i++) {
			Goods goods = (Goods)glist.get(i);
			out.println("<tr>");
			out.println("<td>" + goods.getName() + "</td>");
			out.println("<tr>");
		}
		
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

}
