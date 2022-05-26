/*
통계학 [2108]
시간 제한   메모리 제한  제출  정답  맞은 사람   정답 비율
2 초 256 MB  54275   13414   10821   26.736%
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.

예제 입력 1 
5
1
3
8
-2
2
예제 출력 1 
2
2
1
10
예제 입력 2 
1
4000
예제 출력 2 
4000
4000
4000
0
예제 입력 3 
5
-1
-2
-3
-1
-2
예제 출력 3 
-2
-2
-1
2

*/
package algorithm.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.valueOf(reader.readLine());
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      numbers.add(Integer.valueOf(reader.readLine()));
    }
    
    numbers.sort((i1,i2)->i1.compareTo(i2));
    
    printAverage(numbers);
    printMedian(numbers);
    printMode(numbers);
    printRange(numbers);
  }

  public static void printAverage(List<Integer> numbers) {
    System.out.println(Math.round(numbers.stream().mapToInt(i->i).average().getAsDouble()));
  }
  
  public static void printMedian(List<Integer> numbers) {
    System.out.println(numbers.get(numbers.size()/2));
  }
  
  public static void printMode(List<Integer> numbers) {
    int max = 0;
    Map<Integer,Integer> numberCount = new HashMap<>();
    List<Integer> mode = new ArrayList<>();
    
    for(Integer number : numbers) {
      numberCount.put(number, numberCount.getOrDefault(number, 0)+1);
      max = Math.max(max, numberCount.get(number));
    }
    
    for(Integer number : numberCount.keySet()) {
      if(numberCount.get(number) == max) {
        mode.add(number);
      }
    }
    
    if(mode.size() == 1) {
      System.out.println(mode.get(0));
    } else {
      mode.sort((i1,i2)->i1.compareTo(i2));
      System.out.println(mode.get(1));
    }
  }
  
  public static void printRange(List<Integer> numbers) {
    System.out.println(numbers.get(numbers.size()-1) - numbers.get(0));
  }
  
}
