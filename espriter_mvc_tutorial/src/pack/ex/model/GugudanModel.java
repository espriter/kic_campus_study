package pack.ex.model;

public class GugudanModel {
	public String getGuResult(String gu) {
		String result = "";
		int guNum = Integer.parseInt(gu); 
		
		for(int i= 1; i < 10;  i++) {
				result += guNum +" * " + i +" = " + (guNum*i) + "<br>"; 
		}
		return result;
	}
	
}
