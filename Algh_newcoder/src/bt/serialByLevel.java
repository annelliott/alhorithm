package bt;

import java.util.LinkedList;
import java.util.Queue;

public class serialByLevel {
	public static String serialByLevelAll(Node head) {
		// 若为null，则输入#!
		if (head == null) {
			return "#!";
		}
		// 设置字符串的值
		String res = head.value + "!";
		Queue<Node> queue = new LinkedList<Node>();
		// 设置链表存储左右节点
	    queue.offer(head);
		while (!queue.isEmpty()) {
			// 抛出当前节点，并求出其左右节点，并根据相应情况进行设置字符串
			head = queue.poll();
			if (head.left != null) {
				res += head.left.value + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			if (head.right != null) {
				res += head.right.value + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		} 	
		return res;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		node5.left = node9;
		node5.right = node10;
		node8.right = node11;
		node9.left = node12;
		node11.left = node13;
		node11.right = node14;
		node12.left = node15;
		node12.right = node16;
		String a = serialByLevelAll(node1);
		System.out.println(a);
	}

}
