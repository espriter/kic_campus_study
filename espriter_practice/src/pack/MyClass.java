package pack;

import java.io.PrintWriter;

public class MyClass {
	private String irum;
	
	public MyClass() {
		irum = "홍길동";
	}
	public String getIrum() {
		return irum;
	}
	public void showData(int n, PrintWriter write) {
		try {
			int su = 10 /n;
			write.println("<br>연산 결과" + su);
			
		} catch (Exception e) {
			write.println("<br>오류결과" + e);
		}
	}
}
