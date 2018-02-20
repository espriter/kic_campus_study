package pack2;

public class Gugudan { // 구구단 처리용 클래스

	public Gugudan() {

	}

	public int[] compute(int dan) {
		int gu[] = new int[9];
		for (int i = 1; i < 10; i++) { // 1부터 시작해서 10보다 작게 1씩 플러스
			gu[i - 1] = dan * i;
		}
		return gu;
	}
}