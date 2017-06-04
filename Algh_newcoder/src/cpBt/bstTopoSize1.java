package cpBt;
public class bstTopoSize1 {
	public static int bstTopSize1(Node head) {
		if (head == null) {
			return 0;
		}
		int max = maxTopo(head, head);
		// 从左右节点为头节点来搜寻头节点。
		max = Math.max(max, bstTopSize1(head.left));
		max = Math.max(max, bstTopSize1(head.right));
		return max;
	}
	public static int maxTopo(Node h, Node n) {
		// 固定头节点的情况下，只把符合二叉搜索的节点加入到该节点中。
		if (h != null && n != null && isBstNode(h, n, n.value)) {
			return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
		}
		return 0;
	}
	public static boolean isBstNode(Node h, Node n, int value) {
		if (h == null) {
			return false;
		}
		if (h == n) {
			return true;
		}
		// 按照二叉搜索树的特点，若头节点的值大于该点，则搜索二叉树的左子树，若小于该点的值，
		// 则搜索二叉树的右子树。
		return isBstNode(h.value > value ? h.left : h.right, n, value);
	} 
	public static void main(String[] args) {
		Node node1 = new Node(6);
		Node node2 = new Node(1);
		Node node3 = new Node(12);
		Node node4 = new Node(0);
		Node node5 = new Node(3);
		Node node6 = new Node(10);
		Node node7 = new Node(13);
		Node node8 = new Node(4);
		Node node9 = new Node(14);
		Node node10 = new Node(20);
		Node node11 = new Node(16);
		Node node12 = new Node(2);
		Node node13 = new Node(5);
		Node node14 = new Node(11);
		Node node15 = new Node(15);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node6.left = node8;
		node6.right = node9;
		node7.left = node10;
		node7.right = node11;
		node8.left = node12;
		node8.right = node13;
		node9.left = node14;
		node9.right = node15;
		int max = bstTopSize1(node1);
		System.out.println(max);
	}
}