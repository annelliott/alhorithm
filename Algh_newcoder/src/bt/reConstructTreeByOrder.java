package bt;

import java.util.HashMap;

public class reConstructTreeByOrder {
	// 根据先序和中序建立树
	/* 先序遍历数组的模式是 根节点-根节点的左子树-根节点的右子树
	 * 中序遍历数组的模式是 根节点的左子树-根节点-根节点的右子树
	 * 因此先经过先序遍历的头节点，确定在中序遍历中的位置i，
	 * 顺便将对应的左子树和右子树在中序遍历数组中也确定了下来
	 * 在根据中序数组中所确定的左子树长度，确定了先序数组中的长度
	 * 利用左子树的中序数组和先序数组，迭代构建出左子树*/	
	public static Node preToTree(int[] pre, int[] in) {
		if(pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}
	public static Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj,
			HashMap<Integer, Integer> map) {
		// 如果左端点长度大于右端点，则返回null
		if (pi > pj) {
			return null;
		}
		// 利用先序遍历的左节点来作为头节点
		Node head = new Node(p[pi]);
		// 得出根节点所在的位置index
		int index = map.get(p[pi]);
		// 左子树构造时相应坐标的改变
		head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		// 右子树构造时相应坐标的改变
		head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
		return head;
	}
	/*
	 * 根据中序遍历和后序遍历的数组来进行相应的设计
	 * 后序数组中的顺序是根节点的左子树，根节点的右子树，根节点
	 * 中序数组中的顺序是根节点的左子树，根节点，根节点的右子树
	 * 因此后序数组中的最右节点即根节点
	 * */
	public static Node inPosToTree(int[] in, int[] pos) {
		if (in == null || pos == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return inPos(in, 0, in.length - 1, pos, 0, pos.length - 1, map);
	}
	// 重新进行划分，划分根节点的左子树，根节点的右子树以及根节点
	public static Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj, 
			HashMap<Integer, Integer> map) {
		// 每次都会重新划分后序数组和中序数组
		if (si > sj) {
			return null;
		}
		// 创建根节点
		Node head = new Node(s[sj]);
		// 确定中序数组中相应的位置
		int index = map.get(s[sj]);
		// 中序遍历左子树从 ni 到 index - 1，后序遍历从 si 到 si + index - ni - 1
		head.left = inPos(n, ni, index - 1, s, si, si + index - ni - 1, map);
		// 中序遍历从index + 1 到 nj, 后序遍历从si + index - ni 到sj - 1 
		head.right = inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map);
		// 返回现在的head
		return head;
	}
	public static void main(String[] args) {
		
	}
}