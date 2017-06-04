package cpBt;

public class PostArray {
	public static boolean isPostArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length - 1);
	}
	public static boolean isPost(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		// 定义小于根节点的最右位置的值less
		int less = -1;
		// 定义大于根节点的最左位置的值more
		int more = end;
		// 遍历整个数组，记录less和more
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || more == end) {
			return isPost(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end - 1);
	}
	public static void main(String[] args) {

	}

}
