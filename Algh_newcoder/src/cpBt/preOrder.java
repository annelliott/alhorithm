package cpBt;
public class preOrder {
	public static void preOrderPrint(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.value);
		preOrderPrint(head.left);
		preOrderPrint(head.right);
	}
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3); 
		Node n4 = new Node(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		preOrderPrint(n1);
	}
}
