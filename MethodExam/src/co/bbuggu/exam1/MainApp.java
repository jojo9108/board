package co.bbuggu.exam1;

public class MainApp {

	public static void main(String[] args) {
		MethodTest methodTest = new MethodTest();
		methodTest.strTest();
		String name = methodTest.strTest2();  // return type 호출
		System.out.println(name);
		String str = methodTest.strTest3(); // 
		System.out.println(str);
	}

}
