/* Equal

Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. 
She is biased towards her friends and plans to give them more than the others. 
One of the program managers hears of this and tells her to make sure everyone gets the same number.

To make things difficult, she must equalize the number of chocolates in a series of operations.
 For each operation, she can give 1,2 or 5 pieces to all but one colleague. 
 Everyone who gets a piece in a round receives the same number of pieces.

Given a starting distribution, calculate the minimum number of operations needed so that every colleague has the same number of pieces.

Example

arr = [1,1,5]
arr represents the starting numbers of pieces for each colleague. She can give 2 pieces to the first two and the distribution is then [3,3,5].
 On the next round, she gives the same two 2 pieces each, and everyone has the same number: [5,5,5]. Return the number of rounds, 2.


Function Description

Complete the equal function in the editor below.

equal has the following parameter(s):

int arr[n]: the integers to equalize


Returns

int: the minimum number of operations required


Input Format

The first line contains an integer t, the number of test cases.

Each test case has 2 lines.
- The first line contains an integer n, the number of colleagues and the size of arr.
- The second line contains n space-separated integers, arr[i], the numbers of pieces of chocolate each colleague has at the start.


Constraints
1 <= t <= 100
1 <= n <= 10000

The number of chocolates each colleague has initially < 1000.

Sample Input

STDIN       Function
-----       --------
1           t = 1
4           arr[] size n = 4
2 2 3 7     arr =[2, 2, 3, 7]
Sample Output

2
Explanation

Start with 
Add  to all but the 3rd element 
Add  to all but the 4th element 

Two operations were required.

Sample Input 1

1
3
10 7 12
Sample Output 1

3
Explanation 1



최초로 전달받은 list (초콜릿 갯수)에서
한 원소를 제외한 나머지에 1,2,5 중 하나씩을 더해서
최종적으로 모든 원소의 수를 같게 해줄수 있는 최소 시도 횟수를 구하기



equal_old => 속도 문제로 인해 최적화 필요..

하나를 제외한 나머지에 더해주는 방법 말고
하나의 원소만 빼주는 방법으로 수정.

훨씬 간결해짐.

 */

package algorithm.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Equal {
	static public void main(String[] args) {
		
//		List<Integer> li = Arrays.asList(2,2,3,7);
//		List<Integer> li = Arrays.asList(53,361,188,665,786,898,447,562,272,123,229,629,670,848,994,54,822,46,208,17,449,302,466,832,931,778,156,39,31,777,749,436,138,289,453,276,539,901,839,811,24,420,440,46,269,786,101,443,832,661,460,281,964,278,465,247,408,622,638,440,751,739,876,889,380,330,517,919,583,356,83,959,129,875,5,750,662,106,193,494,120,653,128,84,283,593,683,44,567,321,484,318,412,712,559,792,394,77,711,977,785,146,936,914,22,942,664,36,400,857);
		List<Integer> li = Arrays.asList(1,5,5); /*3*/
		
		System.out.println(equal(li));
		
	}
	
	public static int equal(List<Integer> arr) {
		
		List<Integer> cnt = new ArrayList<>();
		int min = Collections.min(arr);
		
		cnt.add(getCnt(arr, min));
		
		//최소값 기준을 차감 후 계산했을때 더 작은 횟수가 나올수도 있음
		cnt.add(getCnt(arr, min-5));
		cnt.add(getCnt(arr, min-2));
		cnt.add(getCnt(arr, min-1));
		
		return Collections.min(cnt);
	}
	
	public static int getCnt(List<Integer> arr, int min) {
		
		int cnt = 0;
		
		for(int i : arr) {
			
			//최소값과의 차이를 줄이기 위해 차감 되어지는 갯수
			int diff = i - min;
			cnt += (diff/5) + (diff%5)/2 + (diff%5%2);
		}
		
		return cnt;
	}
	
	
	
	
	
	
	
	
	
	
	
		
	public static int equal_old(List<Integer> arr) {
        
		int cnt = 0;
		boolean loop = true;
		List<List<Integer>> arr2 = new ArrayList<>();
		arr2.add(arr);
		
		while(loop){
			
			cnt++;
			
			arr2 = add(arr2);
			if(chkSame(arr2)) loop = false;
			
		}
		
		return cnt;
    }
	
	public static List<List<Integer>> add(List<List<Integer>> arr2) {
		
		List<List<Integer>> lili = new ArrayList<>();
		int[] addNo = {1,2,5};
		
		for(List<Integer> arr : arr2) {
			for(int j=0; j<arr.size(); j++) {
				for(int addN : addNo) {
					List<Integer> li = arr.stream().map(i->i+addN).collect(Collectors.toList());
					li.set(j, li.get(j)-addN);
					lili.add(li);
				}
			}
		}
		
		return lili;
	}
	
	public static boolean chkSame(List<List<Integer>> arr2) {
		
		boolean b = false;
		
		for(List<Integer> arr : arr2) {
			if(arr.stream().distinct().count()==1) {
				b = true;
				break;
			}
		}
		
		return b;
	}
}
