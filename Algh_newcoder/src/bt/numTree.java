package bt;

public class numTree {
	// if the arr have n nodes,judge the in order
	public static int numTree(int n) {
		if (n < 2) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		// consist n node, then judge the Node i(i < n), num[i] have different
		// types of situation, num[i] = num[i] + num[i - j] * num[j - 1]
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				num[i] = num[i] + num[i - j] * num[j - 1];
	 		}
		}
		return num[n];
	}
	public static void main(String[] args) {
		System.out.println(numTree(2));
	}
}