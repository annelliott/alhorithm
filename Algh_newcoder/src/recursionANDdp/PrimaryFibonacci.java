package recursionANDdp;
/*
 * 	如果递推公式满足f(n) = a*f(1) + b*f(2) + ... + g*f(n-1)
 * 	则可以利用状态矩阵来实现。
 * 	时间复杂度为O(log(n))
 * */
	// 斐波那契数列的形式：f(n) = f(n-1) + f(n-2)
	// 二阶递推公式可以转化为状态矩阵乘以参数。
	// 斐波那契数列可以表示为{1,1;1,0}
public class PrimaryFibonacci {
	// 斐波那契数列暴力解法，对于每个f(n)都要求两次,时间复杂度为O(N^2)
	public static int f1(int n) {
		// 首先处理异常
		if (n < 1) {
			return 0;
		}
		// 其次处理初始值
		if (n == 1 || n == 2) {
			return 1;
		}
		return f1(n-1) + f1(n-2);
	}
	// 正常解法，分别求出f(n-1)和f(n-2),然后从前往后推,时间复杂度为O(n)
	public static int f2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int fn1 = 1;
		int fn2 = 1;
		int res = 0;
		for (int i = 3; i <= n; i++) {
			res = fn1 + fn2;
			fn2 = fn1;
			fn1 = res;
		}
		return res;
	}        
	// 通过矩阵的方法来减少计算量，矩阵的n次乘法，其实就是可以通过log(n)得出。
	// 1. 假设一个整数是10,如何最快的求解10的75次方
	// 2. 10的75次方=10^64 * 10^8 * 10^2 * 10^1,在这个过程中，根据10^1求出10^2,
	//    依次求出10^64.总之,75的二进制形式总共有多少位，我们就使用了多少次乘法
	// 3. 64,8,2,1这些位上为1,代表进行相乘运算.其余位上为0,代表不进行相乘运算。
	
	// 首先进行矩阵乘法的计算
	public static int[][] matrixPower(int[][] m, int p) {
		// 首先初始化结果矩阵
		int[][] res = new int[m.length][m[0].length];
		// 先把结果矩阵初始化为单位矩阵,相当于整数中的1
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		// m为被乘的矩阵，res保存从0位到当前位的矩阵
		int[][] tmp = m;
		for (; p != 0; p = (p >> 1)) {
			// 计算当前位是否为0
			if ((p & 1) != 0) {
				// 如果不是，则利用前面的值乘以当前的值
				res = muliMatrix(res, tmp);
			}
			// tmp存储当前位对应的m的2的倍数。
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}
	// 矩阵相乘方法
	public static int[][] muliMatrix(int [][] m1, int[][] m2) {
		// 第一个矩阵的行乘以第二个矩阵的列
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	// 用矩阵乘法求解斐波那契数列第N项的全部过程
	public static int f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n - 2);
		// 利用(f(2),f(1)) * base = (f(n),f(n-1))求得f(n)
		return res[0][0] + res[1][0];
	}
	// 上台阶，一次只能上一个或两个。则第n个台阶只有两种情况，S(n) = S(n-1) + S(n-2)
	// S[1] = 1,S[2] = 2;base = {{1,1},{1,0}}
	public static int S3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = {{1,1},{1,0}};
		int[][] res = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}
	/*	第一年只有一头母猪，并且母猪不会死。母猪每年都会生一只小母猪
	 * 	小母猪过了三年后才会成熟生小母猪 
	 * 	问第N年时，一共有多少头猪。
	 * 	第N年的猪的数量是由第N-1年和第N-3年成熟的那些猪所下的猪仔所决定的。
	 * 	S(1) = 1; S(2) = 2; S(3) = 3;S(4) = 4;S(5) = 6;
	 * 	S(N) = S(N-1) + S(N-3),三阶递推数列可以用3*3矩阵来表示
	 * 	状态转移矩阵为{{1,1,0},{0,0,1},{1,0,0}}
	 * */
	public static int pigNum(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		// 状态转移矩阵base
		int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
		int[][] res = matrixPower(base, n - 3);
		// 二维矩阵res存结果
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}
	public static void main(String[] args) {
		System.out.println(f3(4));
	}
}
