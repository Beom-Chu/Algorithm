/* 동적계획법을 활용한 피보나치 수열  */
package algorithm;

public class DpFibonacci {

	static long[] memo;
	
	public static void main(String[] args) {
		
		int n = 40;
		
		long st = System.currentTimeMillis();
		
		System.out.println(fibo(n));
		
		System.out.println("time:"+(System.currentTimeMillis()-st));
		
		
		long st2 = System.currentTimeMillis();
		
		memo = new long[n+1];
		System.out.println(dpFibo(n));
		
		System.out.println("dpTime:"+(System.currentTimeMillis()-st2));
		
		
		long st3 = System.currentTimeMillis();
		
		memo = new long[n+1];
		System.out.println(bottomUpFibo(n));
		
		System.out.println("dpTime:"+(System.currentTimeMillis()-st3));
		
	}
	
	/* 기본 피보나치 */
	static int fibo(int n)
	{
		if(n<=1) return n;
		
		return fibo(n-1) + fibo(n-2);
	}
	
	/* DP활용 피보나치 - Top-Down */
	static long dpFibo(int n) {
		
		if(n<=1) return n;
		
		if (memo[n] != 0)
			return memo[n];
		else
			return memo[n] = dpFibo(n - 1) + dpFibo(n - 2);
 
    }
	
	/* Bottom-Up 피보나치 */
	static long bottomUpFibo(int n) {

		memo[0]=0;
		memo[1]=1;
		
		for(int i=2; i<=n; i++) {
			memo[i] = memo[i-1]+memo[i-2];
		}
		
		return memo[n];
	}
}
