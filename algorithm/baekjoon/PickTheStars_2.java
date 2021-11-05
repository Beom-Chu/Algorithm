/**
 * 별 찍기 - 2 [2439]
시간 제한 메모리 제한  제출  정답  맞힌 사람 정답 비율
1 초 128 MB  156951  88279 76588 56.897%
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.

예제 입력 1 
5
예제 출력 1 
    *
   **
  ***
 ****
*****

 
 */
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PickTheStars_2 {

  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(reader.readLine());
    int blankCnt = n;
    
    for (int i = 0; i < n; i++) {
      blankCnt--;
      for (int j = 0; j < n; j++) {
        if(j < blankCnt) {
          System.out.print(" ");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }
}
