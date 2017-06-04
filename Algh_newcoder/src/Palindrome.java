import java.util.Stack;


public class Palindrome {
	public boolean isPalindrome(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node right = head.next;
		Node cur = head;
		//一半平分，分出右边的第一个值
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Node> stack = new Stack<Node>();
		// 将右边的值插入
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		// 对左右两边的值进行比对，若有不同的，则返回false
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}			
			head = head.next;
		}
		return true;
	}
	public static boolean isPalindromeNew(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		//区分左右
		Node n1 = head;
		Node n2 = head;
		while (n2.next != null && n2.next.next != null) {
			n1 = n1.next;      // 中部
			n2 = n2.next.next; // 分出结尾
		}
		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while (n2 != null) {  // 右半区反转
			n3 = n2.next;
			n2.next = n1;
			n1 = n2; // n1移动
			n2 = n3; // n2移动
		}
		//进行比对
		n3 = n1; // 转至最右边
		n2 = head; // 转至最左边
		boolean res = true;
		while (n1 != null && n2 != null) {
			if (n1.value != n2.value) {
				res = false;
				break;
			}			
			n1 = n1.next; // 从左边到中部
			n2 = n2.next; // 从右边到中部
		}
		n1 = n3.next;//恢复原链表形状
		n3.next = null;
		while (n1 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(2);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		boolean res = isPalindromeNew(node1);
		System.out.println(res);
	}
}
