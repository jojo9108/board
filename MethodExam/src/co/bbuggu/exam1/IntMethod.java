package co.bbuggu.exam1;

public class IntMethod {
	public void sum() {
		int a = 100;
		int b = 200;
		System.out.println(a+b);
	}
	
	public int sub() {
		int a = 200;
		int b = 100;
		return a - b;
	}
	
	private void mul() {
		int a = 100;
		int b = 200;
		System.out.println(a * b);
	}
	
	public void multiple() {
		mul(); // private 메소드를 내 Class 안에서 호출한다.
	}
}
