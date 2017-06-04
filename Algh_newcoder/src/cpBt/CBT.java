package cpBt;

import java.util.LinkedList;
import java.util.Queue;

public class CBT {
	public static boolean isBCT(Node head) {
		if (head == null) {
			return false;
		}
		Queue<Node> queue = new LinkedList<Node>();
		// 初始时设置叶子节点存在，若只有头节点因为队列不会存在其余节点，则直接返回true
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			// 当前节点若为叶子节点，则左右子树均为空。否则返回false。
			// 当前节点若右子树存在，但是左子树不存在时，则返回false。
			if ((leaf && (l != null || r != null)) || (r != null && l == null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		// 遍历到最后，直接返回true
		return true;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		System.out.println(isBCT(node1));
	}

}
