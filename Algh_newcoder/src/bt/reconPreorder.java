package bt;

import java.util.LinkedList;
import java.util.Queue;

public  class reconPreorder {
	public static Node reconByPreString(String preStr) {
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}
	public static Node reconPreOrder(Queue<String> queue) {
		// 打印出队列的第一个节点
		String value = queue.poll();
		// 以#分左右
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		// 不断遍历左右节点，在左右都为空时返回head节点
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
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
		Node all = reconByPreString("1!2!#!4!7!#!#!8!#!11!13!#!#!14!#!#!3!5!9!12!15!#!#!16!#!#!#!10!#!#!6!#!#!");
		System.out.println(all.value);
	}

}
