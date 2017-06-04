import java.util.Stack;

public class AddList {	
	public Node addList1(Node head1,Node head2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Node cur1 = head1;
		Node cur2 = head2;
		while (head1 != null) {
			s1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			s2.push(head2.value);
			head2 = head2.next;
		}
		int ca = 0;
		int n1 = 0;
		int n2 = 0;
		int n = 0;
		Node node = null;
		Node pre = null;
		//每次先计算出最后一个节点，不断前推
		while (!s1.isEmpty() || !s2.isEmpty()) {
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			//计算数值
			n = n1 + n2 + ca;
			//受限确定好next节点
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		if (ca == 1) {
			pre = node;  
			node = new Node(1);
			node.next = pre;
		}
		return node;
	} 
	public static void main(String[] args) {

	}
}