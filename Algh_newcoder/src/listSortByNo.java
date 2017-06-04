public class listSortByNo {
	public static Node listPartition1(Node head,int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		//遍历数组长度
		while (cur != null) {
			i++;
			cur =cur.next;
		}
		Node[] nodeArr = new Node[i];
		cur = head;
		//将链表中的值存入数组
		for (i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		//在数组中划分出来
		arrPartition(nodeArr, pivot);
		//将数组变化为链表
		for (i = 1; i < nodeArr.length; i++) {
			nodeArr[i-1].next = nodeArr[i];
		}
		nodeArr[i-1].next = null;
		return nodeArr[0];
	}
	// 简化做法，时间复杂度O(n),空间复杂度O(1)
	public static Node listPartition2(Node head,int pivot) {
		Node sH = null; // 小的头
		Node sT = null; // 小的尾
		Node eH = null; // 中的头
		Node eT = null; // 中的尾
		Node bH = null; // 大的头
		Node bT = null; // 大的尾
		Node next = null; // 保留下一个节点
		// 所有的节点分进三个链表中
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		// 小的和相等的相连接
		if (sT != null) {
			sT.next = eH;
			eT = eT == null ? sT : eT;
		}
		// 所有的重新连接
		if (eT != null) {
			eT.next = bH;
		}
		return sH != null ? sH : eH != null? eH : bH;
	}
	public static void arrPartition(Node[] nodeArr,int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				Node temp = nodeArr[++small];
				nodeArr[small] = nodeArr[index];
				nodeArr[index++] = temp; 
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				Node temp = nodeArr[index];
				nodeArr[index] = nodeArr[--big];
				nodeArr[big] = temp;
			}
		}		
	}
	public static void main(String[] args) {
		Node node1 = new Node(9);
		Node node2 = new Node(0);
		Node node3 = new Node(4);
		Node node4 = new Node(5);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		int pivot = 3;
		Node cur = listPartition1(node1, pivot);
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.next;
		}		
	}
}