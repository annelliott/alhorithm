package sort;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if (n < 1) {
//			return;
//		}
        int i = -1;
        int n = 842;
        int[] arr = new int[n];
        int[] arr1 = new int[n];
        int sum = 1;
         
        arr[0] = 1;
        int count = -1;
        // È¥µôÖØ¸´ÔªËØ
        for (i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr1[++count] = arr[i];
			}
		}
        arr1[++count] = arr[i];
        arr = new int[++count];
        for (i = 1; i < count - 1; i++) {
			if (arr1[i] > arr1[i + 1] & arr1[i] > arr1[i - 1] & arr[i - 1] != -1) {
				arr[i] = 1;
				++sum;
			} else if (arr1[i] < arr1[i + 1] & arr1[i] < arr1[i - 1] & arr[i - 1] != 1) {
				arr[i] = -1;
				++sum;
			}
		}
        System.out.println(sum);
    }
}