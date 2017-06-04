
public class listNode {
	public static Node reversePart(Node head,int from,int to) {
		//确定前一个字符
		Node pre = null;
		Node later = null;
		Node allform = head;
		int pos = 0;
		while (allform != null) {
			pos++;
			pre = pos == from - 1 ? allform : pre;
			later = pos == to + 1 ? allform : later;
			allform = allform.next;
		}
		if (from > to || from < 1 || to > pos) {
			return head;
		}
		//找出删除的第一个节点
		allform = pre == null ? head : pre.next;
		Node node1 = allform.next;
		allform.next = later;
		Node next = null;
		while (node1 != later) {
			next = node1.next;
			node1.next = allform;
			allform = node1;
			node1 = next;
		}
		if (pre != null) {
			pre.next = allform;
			return head;
		}
		return allform;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		Node node6 = reversePart(node1,1,3);
		System.out.println(node6.value);
	}
}