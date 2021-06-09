/* 동적계획법을 활용한 피보나치 수열  */
package algorithm;

public class DpFibonacci {

	static long[] memo = new long[100];
	
	public static void main(String[] args) {
		
		long st = System.currentTimeMillis();
		
		System.out.println(fibo(35));
		System.out.println(fibo(30));
		System.out.println(fibo(40));
		
		System.out.println("time:"+(System.currentTimeMillis()-st));
		
		
		long st2 = System.currentTimeMillis();
		System.out.println(dpFibo(35));
		System.out.println(dpFibo(30));
		System.out.println(dpFibo(40));
		
		System.out.println("dpTime:"+(System.currentTimeMillis()-st2));
		
	}
	
	/* 기본 피보나치 */
	static int fibo(int n)
	{
		if(n<=1) return n;
		
		return fibo(n-1) + fibo(n-2);
	}
	
	/* DP활용 피보나치 */
	public static long dpFibo(int n) {
		
		if(n<=1) return n;
		
		if (memo[n] != 0)
			return memo[n];
		else
			return memo[n] = dpFibo(n - 1) + dpFibo(n - 2);
 
    }
	
}
