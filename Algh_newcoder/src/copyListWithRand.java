import java.util.HashMap;

public class copyListWithRand {
	// 通过HashMap重新生成
	public static Node copyListWithRand1(Node head) {
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	// 通过设置一个变量来进行重新设置1->1'->2->2'->3->3'->null
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		Node next = null;
        // 1->2->3变为1->1'->2->2'->3->3'->null后,设置next节点
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		// 重新设置rand节点
		cur = head;
		Node copyRand = null;
		while (cur != null) {
			copyRand = cur.next;
			copyRand.rand = cur.rand == null ? null : cur.rand.next;
			cur = cur.next.next;
		}
		Node res = head.next;
		cur = head;
		// 分离
		while (cur != null) {
			next = cur.next.next;
			copyRand = cur.next;
			cur.next = next;
			copyRand.next = next == null ? null : next.next;
			cur = next; 
		}
		return res;
	}
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		System.out.println(begin);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.next = node2;
		node2.next = node3;
		node1.rand = node3;
		node3.rand = node1;
		node2.rand = null;
		Node head = copyListWithRand2(node1);
		long end = System.currentTimeMillis();
		System.out.println(end);
	}
}