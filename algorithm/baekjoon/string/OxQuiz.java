/*
OX퀴즈 [8958]
시간 제한 메모리 제한  제출  정답  맞은 사람 정답 비율
1 초 128 MB  103118  51711 43670 50.978%
문제
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

출력
각 테스트 케이스마다 점수를 출력한다.

예제 입력 1 
5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX
예제 출력 1 
10
9
7
55
30
*/
package algorithm.baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OxQuiz {

  public static void main(String[] args) throws Exception {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.valueOf(reader.readLine());

    for (int i = 0; i < n; i++) {
      String ox = reader.readLine();
      printScore(ox);
    }
  }

  public static void printScore(String ox) {

    int allScore = 0;
    int nextScore = 1;

    for (char chr : ox.toCharArray()) {

      if (chr == 'O') {
        allScore += nextScore;
        nextScore++;
      } else {
        nextScore = 1;
      }
    }

    System.out.println(allScore);
  }
}
