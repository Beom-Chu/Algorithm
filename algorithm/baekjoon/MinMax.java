/*
최소, 최대 [10818]

시간 제한   메모리 제한  제출  정답  맞은 사람   정답 비율
1 초 256 MB  127401  54679   43306   43.408%

문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 
둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 
모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

예제 입력 1 
5
20 10 35 30 7
예제 출력 1 
7 35
*/
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MinMax {

  /* 메모리:117764kb , 시간:580ms */
  public static void main(String[] args) throws IOException {
    
    List<Integer> rtn = new ArrayList<Integer>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(reader.readLine());
    StringTokenizer st = new StringTokenizer(reader.readLine());


    for (int i = 0; i < N; i++) {
      rtn.add(Integer.valueOf(st.nextToken()));
    }

    System.out.println(rtn.stream().mapToInt(i -> i).min().getAsInt() + " "
        + rtn.stream().mapToInt(i -> i).max().getAsInt());

  }

  /* 메모리:93012kb , 시간:492ms */
  public static void main2(String[] args) throws IOException {
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.valueOf(reader.readLine());
    StringTokenizer st = new StringTokenizer(reader.readLine());

    int min = 1_000_000, max = -1_000_000;

    for (int i = 0; i < N; i++) {
      int num = Integer.valueOf(st.nextToken());

      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    System.out.println(min + " " + max);

  }
}
