package bt;

public class printTree {
	// 直观打印二叉树
	public static void printTree(Node head) {
		System.out.println("二叉树：");
		// 按照先右，再中，再左的顺序进行打印。利用遍历的方法来进行
		printInorder(head, 0, "H", 17);
		System.out.println();
	}
	public static void printInorder(Node head,int height,String to,int len) {
		if (head == null) {
			return;
		}
		// 打印左子树
		printInorder(head.right,height + 1,"v",17);
		// 得出基本的字符
		String val = to + head.value + to;
		// 对其进行补空格运算
		int strLen = val.length();
		// 计算左侧的长度leftLen
		int leftLen = (len - strLen) / 2;
		// 计算右侧的长度rightLen
		int rightLen = len - strLen - leftLen;
		// 补空格进行对齐运算
		val = getSpace(leftLen) + val + getSpace(rightLen);
		
		// 针对每层打印空隙，并将值输出
		System.out.println(getSpace(len * height) + val);
		
		//遍历左边  
		printInorder(head.left, height + 1, "^", len);
	}
	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
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
		printTree(node1);
	}

}
