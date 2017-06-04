
public class RemoveValue {
	public static Node removeValue(Node head,int num) {
		if (head == null || (head.next == null && head.value == num)) {
			return null;
		}
		Node cur = head.next;
		Node pre = head;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			if (cur.value == num) {
				pre.next = cur.next;
				pre = pre.next;
			}else {
				pre = cur;
			}			
			cur = next;
		}
		return head;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		int num = 2;
		Node res = removeValue(node1,num);
		while (res != null) {
			System.out.print(res.value + "->");
			res = res.next;
		}
	}

}
