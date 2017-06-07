package recursionANDdp;

public class minCoins {

	/**
	 * Elliott Su
	 * 最少钱币数量：arr = [2,3,5],aim = 20
	 * 未经过空间压缩之前，时间复杂度和空间复杂度都为O(N*aim)
	 */
	public static int minCoins(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// dp[i][j] 表示可以任意使用arr[0-i]中的钱币，达到j数目的钱
		int[][] dp = new int[n][aim + 1];
		// 进行初始化,意味着如果可以被arr[0]整除，则进行表示
		for (int j = 1; j <= aim; j++) {
			// 除了可以整除的,其余的可以表示为max
			dp[0][j] = max;
			if (j- arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		// 进行相应的赋值运算。dp[i][j]用arr[0...i]中的任意值进行货币组合，合成j
		// dp[i][j]可以为dp[i][j-arr[i]] + 1 和 dp[i - 1][j]组成，选出其中
		// 最小的值
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= aim; j++) {
				// 最大值为max
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}
	
	/** 进行空间压缩
	 * 	时间复杂度为O(aim * N)
	 * 	空间复杂度为O(min(aim)),这是因为按照行来更新,
	 * 	只有dp[i][j] = min(dp[i-1][j],dp[i][j-arr[i]]+1)
	 * 	由上一行的决定,或者由隔着max(arr[i])的列决定，需要多个，因此需要知道max(arr[i]) * N决定
	 * */
	
	public static int minCoin2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		// 按行更新
		int[] dp = new int[aim + 1];
		// 进行初始值的赋值
		for (int i = 1; i <= aim; i++) {
			dp[i] = max;
			if (i - arr[0] >= 0 && dp[i - arr[0]] != max) {
				dp[i] = dp[i - arr[0]] + 1;
			}
		}
		int left = 0;
		// 取最小值，进行运算
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				// 按列进行划分
				if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
					left = dp[j - arr[i]] + 1;
				}
				// 由之前的dp和left所决定的
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}	
	public static void main(String[] args) {
		int[] arr = {2,3,5};
		System.out.println(minCoin2(arr, 20));

	}

}
