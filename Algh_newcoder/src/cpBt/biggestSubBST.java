package cpBt;

public class biggestSubBST {
	public static Node biggestSubBST(Node head) {
		// 记录当前的深度以及节点的最小值和最大值
		int[] record = new int [3];
		head = posOrder(head, record);
		return head;
	}
	public static Node posOrder(Node head, int[] record) {
		if (head == null) {
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return null;
		}
		int value = head.value;
		Node left = head.left;
		Node right = head.right;
		Node lBST = posOrder(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		Node rBST = posOrder(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		record[1] = Math.min(lMin, value);
	    record[2] = Math.max(rMax, value);
	    if (left == lBST && right == rBST && lMax < value && value < rMin) {
			record[0] = lSize + rSize + 1;
			return head;
		}
	    record[0] = Math.max(lSize, rSize);
 	    return lSize > rSize ? lBST : rBST;
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
        Node head = biggestSubBST(node1);
        while (head != null) {
			System.out.println(head.value);
			head = head.left;
		}
	}

}
