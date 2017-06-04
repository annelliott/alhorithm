import java.util.Scanner;
public class Taxi {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        while (in.hasNextInt()) {//注意while处理多个case
	            //初始化数组大小
	        	int n = in.nextInt();
	        	//初始化计算次数
	            int k = in.nextInt();
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
					arr[i] = in.nextInt();
				}
	            for (int i = 0; i < k; i++) {
	            	int ini = arr[0];
					for (int j = 0; j < n-1; j++) {
						arr[j] = (arr[j] + arr[j+1]) % 100;
					}
					arr[n-1] = (arr[n-1] + ini) % 100;
				}
	            for (int i = 0; i < n - 1; i++) {
					System.out.print(arr[i] + " ");
				}
	            System.out.print(arr[n-1]);
	        }
	            //进行计算
	    }	
}
