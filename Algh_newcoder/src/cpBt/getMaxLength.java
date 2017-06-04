package cpBt;

import java.util.HashMap;

public class getMaxLength {
	
	public static int getMaxLength(Node head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0);
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}
	public static int preOrder(Node head, int sum, int preSum,int level,
			int maxLen, HashMap<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);
		if (level == sumMap.get(curSum)) {
			sumMap.remove(curSum);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(-1);
		Node node4 = new Node(1);
        Node node5 = new Node(5);
        Node node6 = new Node(1);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node3.left = node4;
        node3.right = node6;
        System.out.println(getMaxLength(node1, 3));
	}

}
