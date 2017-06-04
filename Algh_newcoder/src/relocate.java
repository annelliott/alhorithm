
public class relocate {
	public static Node relocate(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return head;
		}
		Node slow = head;
		Node fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 判断左右节点left和right
		int count = 1;
		Node nextLeft = null;
		Node nextRight = null;
		Node left = head;
		Node right = slow.next;
		Node term = slow.next;
		// 不断交换左右节点
		while (left != term) {
			if (count % 2 == 1) {
				nextLeft = left.next;
				left.next = right;
				left = nextLeft;
			} else {
				nextRight = right.next;
				right.next = left;
				right = nextRight;
			}
			count++;
		} 
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
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		Node cur = relocate(node1);
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}
	}

}
