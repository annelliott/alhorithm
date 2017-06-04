package cpBt;

import java.util.LinkedList;
import java.util.Queue;

import bt.Node;

public class serialByLevel {
	// BFS构建字符串
	public static String serialByBfsOrder(Node head) {
		if (head == null) {
			return "#!";
		}
		// 进行字符串首部
		String res = head.value + "!";
		// 存储队列
		Queue<Node> queue =  new LinkedList<Node>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			// 抛出当前队列的元素
			head = queue.poll();
			// 存储树左侧的值
			if (head.left != null) {
				res += head.left.value + "!";
				queue.offer(head.left);
			} else {
				res += "#!";
			}
			// 存储树右侧的值
			if (head.right != null) {
				res += head.right.value + "!";
				queue.offer(head.right);
			} else {
				res += "#!";
			}
		}
		return res;
	}
	// 根据BFS序列化结果重建二叉树 
	public static Node reconByLevelString(String str) {
		// 首先进行字符串数组重建
		String[] values = str.split("!");
		int index = 0;
		// 构建队列
		Queue<Node> queue = new LinkedList<Node>();
		// 构建头节点
		Node head = reconString(values[index++]);
		if (head != null) {
			queue.offer(head);
		}
		// 构建节点node
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = reconString(values[index++]);
			node.right = reconString(values[index++]);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return head;
	}
	public static Node reconString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
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
		String a = serialByBfsOrder(node1);
		System.out.println(a);
		Node head = reconByLevelString("1!2!3!#!4!5!6!7!8!9!10!#!#!#!#!#!11!12!#!#!#!13!14!15!16!#!#!#!#!#!#!#!#!");
		System.out.println(head.value);
	}	
}