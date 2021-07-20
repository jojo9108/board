package co.bbuggu.prj;

public class Calculator {
	public int sum(int a, int b) {
		return a + b; // 매개변수

	}

	// 두번째랑 세번째가 같음 -> 함수오버로딩(전달인자나 return value + 개수 가 달라도 된다.)

	public void sub(int a, int b) {
		System.out.println(a - b);

	}

	public void sub(float f, int b) {
		System.out.println(f - b);

	}

	public long sub(long l, long m) {
		return l - m;
	}
}
