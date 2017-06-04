package cpBt;
public class generateBST {
	// 产生平衡搜索二叉树
	public Node generateTree(int[] sortArr) {
		if (sortArr == null) {
			return null;
		}
		return generate(sortArr, 0, sortArr.length - 1);
	}
	// 利用先序遍历构建
	public Node generate(int[] sortArr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node head = new Node(mid);
		head.left = generate(sortArr, start, mid - 1);
		head.right = generate(sortArr, mid + 1, end);
		return head;
	}
	public static void main(String[] args) {

	}
}