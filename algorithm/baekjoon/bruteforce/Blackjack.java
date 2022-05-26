/*
블랙잭 [2798번]

시간 제한   메모리 제한  제출  정답  맞은 사람   정답 비율
1 초 128 MB  63991   29054   22856   44.670%

문제
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 
카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 
블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

예제 입력 1 
5 21
5 6 7 8 9

예제 출력 1 
21

예제 입력 2 
10 500
93 181 245 214 315 36 185 138 216 295

예제 출력 2 
497


*/
package algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Blackjack {
  
  public static void main(String[] args) throws IOException {
    
    try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
    {
      StringTokenizer nm = new StringTokenizer(reader.readLine());
      StringTokenizer numbers = new StringTokenizer(reader.readLine());
      
      int n = Integer.valueOf(nm.nextToken());
      int m = Integer.valueOf(nm.nextToken());
      List<Integer> cards = new ArrayList<>();
      int result = 0;
      
      for(int i=0; i<n; i++) {
        cards.add(Integer.valueOf(numbers.nextToken()));
      }
      
      for(int i=0; i<n-2; i++) {
        for(int j=i+1; j<n-1; j++) {
          for(int k=j+1; k<n; k++) {
            
            int sum = cards.get(i) + cards.get(j) + cards.get(k);
            
            if(sum == m) {
              System.out.println(m);
              return;
              
            } else if(sum < m) {
              
              result = Math.max(result, sum);
            }
          }
        }
      }
      
      System.out.println(result);
    }
    
  }
}
