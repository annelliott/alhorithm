package bt;

import java.util.HashMap;
	// getPosArray by pre order array and in order array
public class getPosArrayByPreandInorderArr {
	
	/* 1. get the head value for the last element of pos array
	 * 2. part the pre order array and the in order array by head value
	 * 3. iterate the step 1,2*/
	
	public static int[] getPosArray(int[] pre, int[] in) {
		// if the pre or in is null, the pos arr is null
		if (pre == null || in == null) {
			return null;
		}
		// get the num of the bt
		int len = pre.length;
		// initial the pos arr
		int[] pos = new int[len];
		// put the in array to the map
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		// change the value of pos order by setPos()
		setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
		return pos;
	}
	public static int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj,
			int[] s, int si, HashMap<Integer, Integer> map) {
		if (pi > pj) {
			return si;
		}
		// put the element of pos array by reverse order 
		s[si--] = p[pi];
		// index means the head node's value in the in order
		int index = map.get(p[pi]);
		// first go through all the right side
		si = setPos(p, pi + index - ni + 1, pj, n, index + 1, nj, s, si, map);
		// then go through all the left side
		return setPos(p, pi + 1, pi + index - ni, n, ni, index - 1, s, si,map);
	}
	public static void main(String[] args) {
		int[] pre = {1,2,4,5,3,6,7};
		int[] in = {4,2,5,1,6,3,7};
		int[] pos = getPosArray(pre, in);
		for (int i = 0; i < pos.length; i++) {
			System.out.println(pos[i]);
		}
	}

}
