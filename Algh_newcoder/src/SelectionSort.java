	// 单链表选择排序
public class SelectionSort {
	// 首尾节点的处理，以及当前最小值节点的连接，新的头节点的标记。
	public static Node SelectionSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node cur = head;
		Node pre = head;
		Node next = null;
		Node preNode = null;
		Node newHead = null;
		while (cur != null) {
			Node mini = head;
			while(cur != null) {
				if (cur.value < mini.value) {
					mini = cur;
					pre.next = cur.next;
				}
				pre = cur;
				cur = cur.next;
			}
			if (mini == head) {
				head = head.next;
			}
			if (preNode != null) {
				preNode.next = mini;
			}
			newHead = preNode == null ? mini : newHead;
			preNode = mini;
			cur = head;
		}
		return newHead;
	}
	public static void main(String[] args) {
		Node node1 = new Node(2);
		Node node2 = new Node(1);
		Node node3 = new Node(7);
		Node node4 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		Node head = SelectionSort(node1);
		while (head != null) {
			System.out.println(head.value);
			head = head.next;
		}
	}

}
