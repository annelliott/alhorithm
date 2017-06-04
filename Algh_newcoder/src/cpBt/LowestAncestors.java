package cpBt;

import java.util.HashMap;

public class LowestAncestors {
	// 发现树中的两个目标节点o1和o2。
	public Node lowestAncestor(Node head, Node o1, Node o2) {
		// 若当前节点为空或除此之外遇到的o1或o2中的某一个值，则将其返回
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		// 当o1和o2都发现之后，则返回父节点。
		if (left != null && right != null) {
			return head;
		}
		// 当只有左子树或右子树之一发现了，或者两者都没发现时，进行输出。
		return left != null ? left : right;
	}
	// 通过建hashmap来搜索最
    public void Record1(Node head) {
    	HashMap<Node, Node> map = new HashMap<Node, Node>();
    	if (head != null) {
			map.put(head, null);
		}
    	
    }
    
}
