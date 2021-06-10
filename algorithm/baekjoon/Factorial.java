/**팩토리얼 [10872]
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

출력
첫째 줄에 N!을 출력한다.

예제 입력 1 
10
예제 출력 1 
3628800
예제 입력 2 
0
예제 출력 2 
1
*/
package algorithm.baekjoon;

import java.util.*;

public class Factorial {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)){
			
			int N = sc.nextInt();
			
			long fr = System.currentTimeMillis();
			
		
			System.out.println(factorial(N));
			
			System.out.println("tiem : "+(System.currentTimeMillis()-fr));
		}
		
	}
	
	static public int factorial(int N) {
		if(N<=1) return 1;
		
		return N * factorial(N-1);
	}
}
