package cpBt;

public class getNextNode1 {
	public static Node1 getNextNode1(Node1 head) {
		if (head == null) {
			return null;
		}
		//  右子树存在，则找到最左节点
		if (head.right != null) {
			Node1 Node1 = head.right;
			while (Node1.left != null) {
				Node1 = Node1.left;				
			}
			return Node1;
		} else {
			Node1 parent = head.parent;
			// 当前节点head若是parent的左子树，则下一个节点为parent
			while (parent != null && parent.left != head) {
				head = parent;
				parent = head.parent;
			}
			return parent;
		}
	}
	public static void main(String[] args) {
		Node1 n1 = new Node1(1);
		Node1 n2 = new Node1(2);
		Node1 n3 = new Node1(3);
		Node1 n4 = new Node1(4);
		n1.left = n2;
		n1.right = n3;
		n2.parent = n1;
		n3.parent = n1;
		n2.left = n4;
		n4.parent = n2;
		Node1 res = getNextNode1(n4);
		System.out.println(res.value);
	}
}