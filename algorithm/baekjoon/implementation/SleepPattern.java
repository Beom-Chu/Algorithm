/*
수면 패턴 [19843번]

문제
사회적 거리두기와 휴학으로 인해 집콕 생활에 익숙해진 민티는 수면 패턴이 자꾸 깨져서 걱정이다.
민티는 건강을 위해 앞으로는 꼭 일주일에 T시간 이상 잠을 자기로 결심했다. 
매일 같은 시간 자고 일어나는 것은 아직 너무 힘들기 때문에, 평일에 자고 일어난 시각을 기록해 두고 주말에 모자란 만큼 몰아서 자기로 했다. 
민티는 한번 잠들면 최소 1시간 이상 잠을 자며, 가끔은 일어나자마자 너무 졸려서 바로 다시 잠들기도 한다.

평일이 다 지나고, 민티에게 마음껏 잘 수 있는 48시간의 주말이 주어졌다. 
민티는 평일에 자신이 적어 놓은 기록을 보고 주말 동안 몇 시간을 자야 하는지 계산하려고 한다.
민티가 평일 동안 잠든 시간과 일어난 시간이 주어질 때, 주말에 자야 할 최소 시간을 출력하라.

입력
일주일에 자야 할 시간을 나타내는 정수 T와 민티가 평일 동안 잠든 횟수를 나타내는 정수 N이 주어진다.
다음 줄부터 N개의 줄에 민티가 잠든 시간이 주어진다. 각 줄에 D1, H1, D2, H2의 순서로 민티가 잠든 시각과 일어난 시각이 주어진다. 
D1은 잠든 요일, H1은 잠든 시각, D2는 일어난 요일, H2는 일어난 시각을 의미한다. 
요일은 Mon, Tue, Wed, Thu, Fri 중 하나이며, 각각 월요일, 화요일, 수요일, 목요일, 금요일을 의미한다. 
시각은 0 이상 23 이하의 정수로 주어지며, 각각 0시부터 23시까지의 시각을 의미한다.

각 수면은 서로 겹치지 않지만, 민티가 일어났다가 바로 잠들 수 있기 때문에 한 수면의 잠든 시각과 다른 수면의 일어난 시각이 동일한 경우가 있을 수 있다. 
수면의 시작과 끝은 항상 평일이며, 입력은 잠든 시각이 빠른 순으로 정렬된 상태로 주어진다. 
민티가 평일 동안 잠을 아예 자지 않는 경우가 존재할 수 있음에 유의하라.

출력
민티가 주말에 더 자야 할 시간을 출력한다. 
만약 주말에 잠을 자지 않아도 충분할 경우 0을, 주말 내내 자도 부족할 경우 -1을 출력한다.

제한
0 ≤ T ≤ 168
0 ≤ N ≤ 10

예제 입력 1 
56 6
Mon 22 Tue 2
Tue 15 Tue 19
Tue 19 Wed 4
Wed 17 Thu 1
Thu 12 Thu 17
Fri 4 Fri 12

예제 출력 1 
18

예제 입력 2 
50 5
Mon 0 Mon 11
Tue 2 Tue 12
Wed 0 Wed 10
Thu 3 Thu 15
Fri 11 Fri 23

예제 출력 2 
0

예제 입력 3 
120 5
Mon 0 Mon 11
Tue 2 Tue 12
Wed 0 Wed 10
Thu 3 Thu 15
Fri 11 Fri 23

예제 출력 3 
-1

0 <= H <= 23
D : Mon, Tue, Wed, Thu, Fri

 */

package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SleepPattern {

  static List<String> dayOfTheWeek = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri");

  static public void main(String[] args) throws IOException {

    try (InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr)) {

      StringTokenizer st = new StringTokenizer(reader.readLine());

      int T = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int sum = 0;

      for (int i = 0; i < N; i++) {

        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        String D1 = st2.nextToken();
        int H1 = Integer.parseInt(st2.nextToken());
        String D2 = st2.nextToken();
        int H2 = Integer.parseInt(st2.nextToken());

        sum += (dayOfTheWeek.indexOf(D2) - dayOfTheWeek.indexOf(D1)) * 24;
        sum += H2 - H1;
      }

      int remainder = T - sum;

      if (remainder < 1) {
        System.out.println(0);
      } else if (remainder > 48) {
        System.out.println(-1);
      } else {
        System.out.println(remainder);
      }
    }

  }

}
