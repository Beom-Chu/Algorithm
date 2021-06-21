/*
Candies

Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  
All the children sit in a line and each of them has a rating score according to his or her performance in the class. 
Alice wants to give at least 1 candy to each child. 
If two children sit next to each other, then the one with the higher rating must get more candies. 
Alice wants to minimize the total number of candies she must buy.

Example
arr = [4,6,4,5,6,2]

She gives the students candy in the following minimal amounts: [1,2,1,2,3,1]. 
She must buy a minimum of 10 candies.

Function Description
Complete the candies function in the editor below.

candies has the following parameter(s):
int n: the number of children in the class
int arr[n]: the ratings of each student


Returns
int: the minimum number of candies Alice must buy

Input Format
The first line contains an integer, n, the size of arr.
Each of the next n lines contains an integer arr[i indicating the rating of the student at position i.

Constraints
1 <= n <= 10^5
1 <= arr[i] <= 10^5

Sample Input 0
3
1
2
2

Sample Output 0
4

Explanation 0
Here 1, 2, 2 is the rating. 
Note that when two children have equal rating, they are allowed to have different number of candies. 
Hence optimal distribution will be 1, 2, 1.

Sample Input 1
10
2
4
2
6
1
7
8
9
2
1

Sample Output 1
19

Explanation 1
Optimal distribution will be 1,2,1,2,1,2,3,4,2,1

Sample Input 2
8
2
4
3
5
2
6
4
5

Sample Output 2
12

Explanation 2
Optimal distribution will be 1,2,1,2,1,2,1,2.


* 분석
1. arr 배열의 점수에 따라서 사탕을 나누어 주는데 양옆의 점수보다 높으면 캔디를 더 많이 나눠줘야 함.
2. 캔디는 최소 1개 이상 주어야함.
3. 점수가 같은 경우에는 캔디를 서로 다르게 줄수 있음.

** 접근방법
* arr1 : 배열 앞에서부터 진행하며 앞의 점수보다 높은 경우 이전갯수+1, 낮은 경우 1 등록
* arr2 : 배열 뒤에서부터 진행하며 뒤의 점수보다 높은 경우 이전갯수+1, 낮은 경우 1 등록
* arr1, arr2 중 더 큰 갯수의 숫자가 주어져야하는 캔디의 수

*/
package algorithm.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Candies {

  public long candies(int n, List<Integer> arr) {

    long rtn = 0;
    List<Integer> arr1 = new ArrayList<>();
    List<Integer> arr2 = new ArrayList<>();

    arr1.add(1);
    arr2.add(1);

    for (int i = 0; i < n - 1; i++) {
      
        //정방향으로 앞뒤 점수 비교하며 높아질 경우 +1 아니면 1
        if (arr.get(i) < arr.get(i + 1)) {
            arr1.add(arr1.get(i) + 1);
        } else {
            arr1.add(1);
        }
        
        //역방향으로 앞뒤 점수 비교하며 높아질 경우 +1 아니면 1
        if (arr.get(n - i - 1) < arr.get(n - i - 2)) {
            arr2.add(0, arr2.get(0) + 1);
        } else {
            arr2.add(0, 1);
        }
    }
    
    for(int i=0; i<n; i++) {
        //두배열 비교하면 큰값으로 갯수 더하기
        rtn += Math.max(arr1.get(i), arr2.get(i));
    }
    
    return rtn;
  }
}
