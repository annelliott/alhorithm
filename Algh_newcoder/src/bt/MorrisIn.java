package bt;

public class MorrisIn {
	// 时间复杂度O(n)，额外空间复杂度O(1)
	public static void morrriIn(Node head) {
		if (head == null || head.left == null && head.right == null) 
			return;
		Node cur1 = head;
		Node cur2 = null;
		while (cur1 != null) {
			// 判断左子树是否存在，若存在，不断向左遍历。
			cur2 = cur1.left;
			// 构造左子树的最右节点
		    if (cur2 != null) {
		    	// 不断向右遍历当前以cur1节点为头节点的左子树，直到最右节点找到。
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;					
				}
				
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					// 搜寻下一个节点，找其最右节点
					continue;
				} else {
					cur2.right = null;
				}
			}
		    // 到达左侧节点或清除标记后，则输出当前点
		    System.out.println(cur1.value);
		    // 左侧到头后向右返回中间及下面及头节点
		    cur1 = cur1.right;
		}
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		morrriIn(node1);
	} 
}