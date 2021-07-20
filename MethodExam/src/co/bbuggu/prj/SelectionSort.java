package co.bbuggu.prj;

public class SelectionSort {
	private int[] arr = { 5, 2, 4, 1, 3 };

	public void selectSort() { // 전통적 선택소트
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) { // asc Sort(작은것보다 앞으로 가는것) < decs Sort
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int n : arr) {
			System.out.print(n + " : ");
		}

	}

	public void selectSort2() {  //진화된 선택소트
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		} //sort end
		for(int n : arr) {
			System.out.println(n + " : ");
		}
	} //method end
}
