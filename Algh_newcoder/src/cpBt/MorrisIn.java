package cpBt;

import java.util.ArrayList;
import java.util.LinkedList;

public class MorrisIn {
	// 判断是否为二叉搜索树
	public static ArrayList<Integer> isBST(Node head) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (head == null) {
			System.out.println("Empty Tree");
			return null;
		}
		Node cur1 = head;
		Node cur2 = null;
		// 根据头节点进行判断
		while (cur1 != null) {
			// cur2为cur1的左子树
			cur2 = cur1.left;
			// 在cur2不为空时，进行其余运算
			if (cur2 != null) {
				// 当cur2的右子树不为空，且不为父节点时
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;					
				}
				// 第一次遍历到左子树的最右节点。
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					// 遍历到最右节点
					cur2.right = null;
				}
			}
			// 当cur1遍历到叶子节点时，会将cur1的值输出
			list.add(cur1.value);
			// 遍历到cur1的右节点
			cur1 = cur1.right;
		}
		return list;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node4.left = node5;
		ArrayList<Integer> list = isBST(node1);
		int count = 1;
		while (count < list.size()) {
			if (list.get(count) < list.get(count-1)) {
				System.out.println("false");
				break;
			}
			count++;
		}
		System.out.println("end!!!");
	}

}
