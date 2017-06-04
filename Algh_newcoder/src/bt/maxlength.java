package bt;

public class maxlength {
	public static int getMaxLength(Node head) {
		int[] record = new int [1];
		return posOrder(head, record);
	}
	public static int posOrder(Node head, int[] record) {
		// 若遍历到叶子节点，则相应的record最大深度记录为0，同时此时为最低点，需对其记录为0
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		// 遍历左子树，返回当前节点左子树下的最多节点数
		int lmax = posOrder(head.left, record);
		// 返回当前根节点下左子树的最大深度 
		int maxFromLeft = record[0];
		int rmax = posOrder(head.right, record);
		int maxFromRight = record[0];
		// 记录当前节点下最左加最右+1的最多节点数
		int curNodeMax = maxFromLeft + maxFromRight + 1;
		// 从头到尾，每个高度只能取一个点
		record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
		// 记录最多节点数，并返回。
		// 其中最多节点数是由左子树最多，右子树最多和当前的最深节点来决定的
		return Math.max(Math.max(lmax, rmax), curNodeMax);
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n4.left = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		System.out.println(getMaxLength(n1));
	}
}