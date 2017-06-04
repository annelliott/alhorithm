package cpBt;

public class reConstructPostArr {
	public Node postArrayTOBST(int[] posArr) {
		if (posArr == null) {
			return null;
		}
		return postToBST(posArr, 0, posArr.length - 1);
	}
	public Node postToBST(int[] posArr, int start, int end) {
		if (start > end) {
			return null;
		}
		Node head = new Node(posArr[end]);
		//记录左节点
		int less = -1;
		// 记录右节点
		int more = end;
		for (int i = start; i < end; i++) {
			if (posArr[end] > posArr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		head.left = postToBST(posArr, start, less);
		head.right = postToBST(posArr, more, end - 1);
		return head;
	}
	public static void main(String[] args) {

	}
}