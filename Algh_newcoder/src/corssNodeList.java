
public class corssNodeList {
	public Node getLoopNode(Node head) {
		// 首先判断是否能构成环的基本条件
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next;
		Node n2 = head.next.next;
		// 其次判断是否有环，无环返回null，有环则先找到fast和slow节点相遇的位置
		// 具体做法是设置两个快慢指针
		while (n1 != n2) {
			if (n1.next == null || n2.next == null) {
				return null;
			}
			n1 = n1.next;
			n2 = n2.next.next;
		}
		// 相遇后则将fast指针指向头节点。
		n2 = head;
		// 重新遍历，找到相遇节点
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	// 判断无环情况下的单链表相交问题
	// 需要注意的是，相交后便不再分开
	public Node noLoop(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		//长度计数器
		int n = 0;
		while (cur1 != null) {
			n++;
			cur1 = cur1.next;			
		}
		while (cur2 != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	//  判断两个链表中有环存在的情况下代码的实现
	public Node bothLoop(Node head1,Node head2,Node loop1,Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		//两个环相交点相同时
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			// 两个带环链表未重合时
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
			// 判断两个交叉点时的情况,则在环里进行
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return cur1;
				}				
				cur1 = cur1.next;
			}
			return null;
		}
	}
	public Node getIntersectNode(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1,head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, head2, loop1, loop2);
		}
		return null;
	}
	public static void main(String[] args) {
		
	}
}
