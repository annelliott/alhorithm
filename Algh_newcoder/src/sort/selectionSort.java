package sort;

public class selectionSort {
	public static void selectSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n - 1; i++) {
			// 标记最小值
			int mini = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[mini]) {
					mini = j;
				}
			}
			temp = arr[mini];
			arr[mini] = arr[i];
			arr[i] = temp;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,4,3,2,8,6};
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
