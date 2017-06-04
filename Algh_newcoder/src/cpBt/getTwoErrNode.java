package cpBt;

import java.util.Stack;

public class getTwoErrNode {
	public Node[] getTwoErrorNode(Node head) {
		Node[] err = new Node[2];
		if (head == null) {
			return err;
		}
		Stack<Node> stack = new Stack<Node>();
		Node pre = null;
		while (!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if (pre != null && pre.value > head.value) {
					err[0] = err[0] == null ? pre : err[0]; // 第一个是大的一个
					err[1] = head; // 第二个恰好是后面小的一个。
				}
				pre = head;
				head = head.right;
			}
		}
		return err;
	}
	public static void main(String[] args) {

	}

}
