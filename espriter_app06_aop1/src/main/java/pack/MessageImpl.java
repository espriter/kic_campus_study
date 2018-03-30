package pack;

public class MessageImpl implements MessageInter{
	// 핵심로직을 가진 클래스 : AOP의 target이 됨
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHi() {
		System.out.println("안녕" + name + "님!핵심로직 수행 중");

	}
}
