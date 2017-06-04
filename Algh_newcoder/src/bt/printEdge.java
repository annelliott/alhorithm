package bt;

public class printEdge {
	public static void printEdge1(Node head) {
		if (head == null) {
			return;
		}
		// 递归返回树的高度
		int height = getHeight(head,0);
		// 打印edgeMap
		Node[][] edgeMap = new Node[height][2];
		// 将树每层的左右元素放入数组中
		setEdgeMap(head, 0, edgeMap);
		// 打印左边界
		for (int i = 0; i < edgeMap.length; i++) {
			System.out.println(edgeMap[i][0].value + " ");
		}
		// 利用先序遍历打印叶子节点
		printLeafNode(head, 0, edgeMap);
		// 打印右边界
		for (int i = edgeMap.length - 1; i >= 0; i--) {
			System.out.println(edgeMap[i][1].value + " ");
		}
		System.out.println();
	}
	public static int getHeight(Node head,int i){
		if (head == null) {
			return i;
		}
		// 递归返回左右节点的最后
		return Math.max(getHeight(head.left,i + 1), getHeight(head.right,i + 1));
	}
	// 将树每层的左右元素放入数组中
	public static void setEdgeMap(Node head,int l,Node[][] edgeMap) {
		if (head == null) 
			return;
		edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
		edgeMap[l][1] = head;
		setEdgeMap(head.left, l + 1, edgeMap);
		setEdgeMap(head.right, l + 1, edgeMap);
	}
	// 利用先序遍历打印叶子节点
	public static void printLeafNode(Node head,int l,Node[][] edgeMap){
		if (head == null) {
			return;
		}
		if (head.left == null && head.right == null && head != edgeMap[l][0] && head != edgeMap[l][1]) {
			System.out.println(head.value + " ");
		}
		printLeafNode(head.left, l + 1, edgeMap);
		printLeafNode(head.right, l + 1, edgeMap);
	}
	// 按照标准二进行打印
	public static void printEdge2(Node head) {
		if (head == null) 
			return;
		System.out.println(head.value + " ");
		if (head.left != null && head.right != null) {
			// 打印左右子树中的边界节点
			printLeftLeafNode1(head.left,true);
			printRightLeafNode1(head.right,true);
		} else {
			// 未找到头节点之前
			printEdge2(head.left != null ? head.left : head.right);
		}
		System.out.println();
	}
	// 打印左子树
	public static void printLeftLeafNode1(Node head,boolean print) {
		if (head == null) 
			return;
		// 不断搜寻左右节点,先向左搜索，打印出叶子节点
		printLeftLeafNode1(head.left, print);
		// 已经搜寻过的左节点将print设置为false,只有叶子节点和右边界路径上的数字可以打印出来
		printLeftLeafNode1(head.right, print && head.left == null ? true : false);
		if (print || head.left == null && head.right == null) {
			System.out.println(head.value + " ");
		}
	}
	public static void printRightLeafNode1(Node head,boolean print) {
		if (head == null)
			return;
		if (print || head.left == null && head.right == null) {
			System.out.println(head.value + " ");
		}
		//不断搜寻左右节点
		printRightLeafNode1(head.left,print && head.right == null ? true : false);
		printRightLeafNode1(head.right, print);
		
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
		printEdge2(node1);
	}

}
