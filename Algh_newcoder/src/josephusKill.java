public class josephusKill {
	public static Node josephusKill(Node head,int m) {
		if(head == null || head == head.next || m < 1){
			return head;
		} else{
		Node node1 = head;
		int count = 1;
		while (node1 != null & node1.next != null & node1.next != node1) {
			if (count == m-1) {
				node1.next = node1.next.next;
				node1 = node1.next;
				count = 1;
			} else {
				node1 = node1.next;
				count++;
			}					
		}
		return node1;
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		Node last = josephusKill(node1,3);
		System.out.println(last.value);
	}

}
