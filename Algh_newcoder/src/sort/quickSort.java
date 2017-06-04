package sort;
public class quickSort {
	public static void quickSortAll(int[] arr,int left,int right) {
		if (right <= left || right < 0 || left < 0) {
			return;
		}
		int pivot = quick(arr,left,right);
		quickSortAll(arr, left, pivot - 1);
		quickSortAll(arr, pivot + 1, right);
	}
	public static int quick(int[] arr,int left,int right) {
		int i = left;
		int big = right + 1;
		int small = left - 1;
		int par = arr[left];
		int temp;
		while (i != big) {
			if (arr[i] < par) {
				small++;
				temp = arr[i];
				arr[i] = arr[small];
				arr[small] = temp;
				i++;
			} else if (arr[i] == par) {
				i++;
			} else {
				big--;
				temp = arr[i];
				arr[i] = arr[big];
				arr[big] = temp;
			}	
		}
		return big - 1;
	}
	public static void main(String[] args) {
		int[] arr = {3,1,3,1,5,1,2,7};
		quickSortAll(arr, 0, 6);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
