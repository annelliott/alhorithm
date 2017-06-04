package bt;
public class Bt {
	// 先序遍历递归过程
	public void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	// 中序遍历递归过程
	public void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value + " ");
		inOrderRecur(head.right);
	}
	// 后序遍历递归过程
	public void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		preOrderRecur(head.right);
		System.out.println(head.value + " ");		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
