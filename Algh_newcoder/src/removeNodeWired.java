import javax.management.RuntimeErrorException;


public class removeNodeWired {
	public void removeWiredNode(Node node) {
		if (node == null) {
			return;
		}
		Node next = node.next;
		if (next == null) {
			throw new RuntimeException("can not remove last node.");
		}
		node.value = next.value;
		node.next = next.next;
	}
	public static void main(String[] args) {

	}
}