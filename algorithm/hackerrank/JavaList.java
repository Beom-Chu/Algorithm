/*
Java List

For this problem, we have 2 types of queries you can perform on a List:

Insert y at index x:

Insert
x y
Delete the element at index x:

Delete
x
Given a list, L, of N integers, perform Q queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format

The first line contains an integer, N (the initial number of elements in L).
The second line contains N space-separated integers describing L.
The third line contains an integer, Q (the number of queries).
The 2Q subsequent lines describe the queries, and each query is described over two lines:

If the first line of a query contains the String Insert, then the second line contains two space separated integers x y, and the value y must be inserted into L at index x.
If the first line of a query contains the String Delete, then the second line contains index , whose element must be deleted from L.

Constraints
1 <= N <= 4000
1 <= Q <= 4000
Each element in is a 32-bit integer.

Output Format

Print the updated list L as a single line of space-separated integers.

Sample Input

5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output

0 1 78 12 23


첫번째 입력값 : 리스트 항목 수
두번째 입력값 : 리스트 각각의 값
세번째 입력값 : Insert, Delete 건수

Insert인 경우
  첫번째 입력값을 index로 두번째 입력값을 value로 등록
delete인 경우
  첫번째 입력값을 index로 제거

*/
package algorithm.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {
	
	static public void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
        int listCnt = sc.nextInt();
        
        for(int i=0; i<listCnt; i++){
            list.add(sc.next());
        }
        
        int inDelCnt = sc.nextInt();
        
        for(int i=0; i<inDelCnt; i++){
        	
            if(sc.next().equals("Insert")){
            	
                list.add(sc.nextInt(),sc.next());
                
            }else{
            	
                list.remove(sc.nextInt());
            }
        }
        
        sc.close();
        
		System.out.println(String.join(" ", list));
		
	}
}
