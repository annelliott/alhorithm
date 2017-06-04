
public class josephusKill1 {
	public Node JosePhusKill(Node head,int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		int count = 1;
		Node curNode = head;
		while (curNode != head) {
			curNode = curNode.next;
			count++;
		}
		count = getAlive(count, m);
		while (--count != 0) {
			head = head.next;			
		}
		head.next = head; 
		return head;
	}
	public int getAlive(int i,int m) {
		if (i == 1) {
			return i;
		}
		return (getAlive(i - 1, m)+ m - 1) % i + 1;
	}
	public static void main(String[] args) {

	}

}
