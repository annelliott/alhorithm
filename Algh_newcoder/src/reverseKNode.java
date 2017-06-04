import java.util.Stack;

public class reverseKNode {
	// 利用栈结构来实现K个节点的逆序
	public Node reverseKNode1(Node head,int k) {
		if (k < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		// 需要返回的是newHead
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Node next = null;
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				pre = resign(stack,pre,next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	// 对栈中的数据重新进行分配
	public Node resign(Stack<Node> stack,Node left,Node right) {
		Node cur = stack.pop();
		if (left != null) {
			left.next = cur;
		}
		Node next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
	// 在不调整情况下进行每K个链表的逆序
	public Node reverseKNode2(Node head,int k) {
		// 返回的头节点newHead
		if (k < 2) {
			return head;
		}
		Node pre = null;
		Node newHead = head;
		Node start = null;
		Node cur = head;
		Node next = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			// 当达到第K个节点时，则反转首尾节点
			if (count == k) {
				start = pre == null ? head : pre.next;
				newHead = pre == null ? cur : newHead;
				// 重新对K个节点的首尾进行规划
				resign2(pre,start,cur,next);
				pre = start;
				count = 0;
			}
			count++;
			cur = next;			
		}
		return newHead;
	}
	public void resign2(Node left,Node start,Node end,Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		// 完成内部节点的反转
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;			
		}
		// 连接前部节点
		if (left != null) {
			left.next = end;
		}
		// 连接后部节点
		start.next = right;
	}
	public static void main(String[] args) {
		
	}

}
