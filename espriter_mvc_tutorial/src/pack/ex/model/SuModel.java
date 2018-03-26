package pack.ex.model;

public class SuModel {
	public String getSuResult(String su) {
		String result="";
		int suNum = Integer.parseInt(su); 
		
		for(int i= 1; i <= suNum;  i++) {
			if(i % 2 == 0) {
				result += i + " ";
			}	 
		}
		System.out.println("su" +result);
		return result;
	}
	
}
