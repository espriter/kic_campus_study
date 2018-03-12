package pack.order;

import java.util.Hashtable;

public class CartMgr {

	private Hashtable hCart = new Hashtable<>();
	
	public void addCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		int quantity = Integer.parseInt(obean.getQuantity());
		
		if(quantity > 0) {
		//동일 상품에 대한 주문인 경우는 주문수량만 수정해서 카트에 담기
		 if(hCart.containsKey(product_no)) {
			 OrderBean imsi = (OrderBean)hCart.get(product_no);
			 quantity += Integer.parseInt(imsi.getQuantity());
			 imsi.setQuantity(Integer.toString(quantity));
			 hCart.put(product_no, imsi);
			// System.out.println("상품번호 : " + product_no + ", 주문수량:" + quantity);
		 }else {
			 hCart.put(product_no, obean);
		 }
		}
	}
	
	public Hashtable getCartList() {
		return hCart;
	}
	
	public void updateCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		hCart.put(product_no, obean);
	}
	
	public void deleteCart(OrderBean obean) {
		String product_no = obean.getProduct_no();
		hCart.remove(product_no);
	}
	
}















