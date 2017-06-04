import java.util.HashSet;


public class removeRep {
	// 时间复杂度O(N),空间复杂度O(N)
	public Node removeValue1(Node head) {
		if (head == null) {
			return head;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		set.add(head.value);
		while (cur != null) {
			if (set.contains(cur.value)) {
				pre.next = cur.next;
			} else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}
	// 时间复杂度O(n^2),额外空间复杂度O(1)
	public Node removeRep2(Node head) {
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			pre = cur;
			next = cur.next;
			while (next != null) {
				if (pre.value == cur.value) {
					pre.next = cur.next;
				} else {
					pre = next;
				}
				next = next.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {

	}
}
