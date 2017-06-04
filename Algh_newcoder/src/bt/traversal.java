package bt;
import java.util.Stack;
public class traversal {
	public static void preTraversal(Node head) { // 先序遍历
		System.out.println("preOrderTraversal");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			// 先后插入右左节点
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	public static void inTraversal(Node head) { // 中序遍历
		System.out.println("inTraversal");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head !=  null) {
				if (head != null) {
					// 压入一个左边的点
					stack.push(head);
					head = head.left;
				} else {
					// 跳出当前栈顶点
					head = stack.pop();
					System.out.println(head.value + " ");
					// 压入右边的顶点
					head = head.right;
				}
			}
		}
		System.out.println();
	} 
	// 使用两个栈，先放进头节点，然后抛出到s2，然后s1压入head的左右节点
	public void posOrderTraversal1(Node head) {
		System.out.println("pos-order");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.println(s2.pop().value + " ");
			}
		}
		System.out.println();
	}
	// 后序遍历，只用一个栈实现后序遍历
	public void posOrderTraversal2(Node h) {
		System.out.println("pos-order: ");
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) { // 左子树未打印
					stack.push(c.left);
				} else if (c.right != null && h != c.right) { // 右子树未打印
					stack.push(c.right);
				} else { // 左右子树均已打印完毕，进一步打印c
					System.out.println(stack.pop().value + " ");
					h = c;
				}
			}
		}
	}
	public static void main(String[] args) {

	}
}