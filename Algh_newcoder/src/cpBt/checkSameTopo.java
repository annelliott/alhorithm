package cpBt;
// 判断t1子树中是否包含t2的拓扑。
public class checkSameTopo {
	// 第一步，先找出相同的节点，通过递归来进行，
	public boolean contains(Node t1, Node t2) {
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}
	// 第二步，当第二个子树节点遍历到空节点时，判断为true。当第二个子树不为空，第一个子树
	//为空时，则判断为false。或两者都不为空，但是值不等时，判断为false。
	// 当二者相等时，则判断左右节点是否相等。
	public boolean check(Node h, Node t2) {
		// 一步步判断相应的节点，若对比到最后，发现t2为空，则证明二者相等。
		if(t2 == null) {
			return true;
		}
		// 当天t2不为空，但是h为空，或h和t2值不同时，需要返回false
		if (h == null || h.value != t2.value) {
			return false;
		}
		// 当头结点值相等时，比较左右节点。直到左右节点都可以，再进行别的。
		return check(h.left, t2.left) && check(h.right, t2.right);
	}
	public static void main(String[] args) {

	}
}