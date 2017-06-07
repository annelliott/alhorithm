package recursionANDdp;

// 统计最小矩阵路径和，每次只能向下且向右。
// 本题主要提出了传统的DP算法和空间压缩算法。
// 传统的DP，时间复杂度为M*N,额外空间复杂度也为M*N,但是有点在于能够记录走过的路径
// 空间压缩算法时间复杂度不变，但是额外空间复杂度为min(M,N).缺点在于不能记录最短路径
public class minPathSum1 {          
	
	// 暴力解法，假设有M行，N列，则相应的时间复杂度为O(M*N),额外空间复杂度为O(M*N)
	// 用dp[i][j]表示在(i,j)位置,相应的最短路径
	
	public static int minPath1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		// 得出行数和列数
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		
		// 进行初始值赋值。
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int i = 0; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = m[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[row - 1][col - 1];
	}
	
	// 进行空间压缩，时间复杂度无法改变，将空间复杂度改为O(min{M,N})
	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length); // 得出大的那个是行数还是列数
		int less = Math.min(m.length, m[0].length); // 得出小的那个是行数还是列数
		boolean rowmore = more == m.length;         // 得出大的那个是行数还是列数，如果是行数，则压缩矩阵的大小为列数，
    // 压缩的方向为向右。
		// 初始化数组，若为rowmore,则应该为列数，同样初始化的为第一行。
		int[] arr = new int[less];
		arr[0] = m[0][0];
		for (int i = 0; i < less; i++) {
			arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
		}
		// 进行矩阵压缩
		for (int i = 0; i < more; i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
			for (int j = 0; j < less; j++) {
				arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
		return arr[less - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
