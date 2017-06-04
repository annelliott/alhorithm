
public class insertNum {
	// 单向环形链表中插入新节点
	public Node insertNum(Node head,int num) {
		Node node = new Node(num);
		if (head == null) {
			node.next = node;
			return node;
		}
		//记录前置节点
		Node pre = head;
		Node cur = head.next;
		// 判断插入点
		while (cur != head) {
			if (pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
