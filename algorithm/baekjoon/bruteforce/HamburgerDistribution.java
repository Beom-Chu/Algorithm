/*
햄버거 분배[19941]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	256 MB	11061	5370	4368	50.057%
문제
기다란 벤치 모양의 식탁에 사람들과 햄버거가 아래와 같이 단위 간격으로 놓여 있다.
사람들은 자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있다.

햄버거	사람	햄버거	사람	햄버거	사람	햄버거	햄버거	사람	사람	햄버거	사람
1	2	3	4	5	6	7	8	9	10	11	12
위의 상태에서 K = 1인 경우를 생각해보자. 이 경우 모든 사람은 자신과 인접한 햄버거만 먹을 수 있다.
10번의 위치에 있는 사람은 11번 위치에 있는 햄버거를 먹을 수 있다.
이 경우 다음과 같이 최대 5명의 사람이 햄버거를 먹을 수 있다.

2번 위치에 있는 사람: 1번 위치에 있는 햄버거
4번 위치에 있는 사람: 5번 위치에 있는 햄버거
6번 위치에 있는 사람: 7번 위치에 있는 햄버거
9번 위치에 있는 사람: 8번 위치에 있는 햄버거
10번 위치에 있는 사람: 11번 위치에 있는 햄버거`
12번 위치에 있는 사람: 먹을 수 있는 햄버거가 없음
K = 2인 경우에는 6명 모두가 햄버거를 먹을 수 있다.

2번 위치에 있는 사람: 1번 위치에 있는 햄버거
4번 위치에 있는 사람: 3번 위치에 있는 햄버거
6번 위치에 있는 사람: 5번 위치에 있는 햄버거
9번 위치에 있는 사람: 7번 위치에 있는 햄버거
10번 위치에 있는 사람: 8번 위치에 있는 햄버거
12번 위치에 있는 사람: 11번 위치에 있는 햄버거
식탁의 길이 N, 햄버거를 선택할 수 있는 거리 K, 사람과 햄버거의 위치가 주어졌을 때,
햄버거를 먹을 수 있는 사람의 최대 수를 구하는 프로그램을 작성하시오.

입력
첫 줄에 두 정수 N과 K가 있다.
그리고 다음 줄에 사람과 햄버거의 위치가 문자 P(사람)와 H(햄버거)로 이루어지는 길이 N인 문자열로 주어진다.

출력
첫 줄에 햄버거를 먹을 수 있는 최대 사람 수를 나타낸다.

제한
1 <= N <= 20,000
1 <= K <= 10
예제 입력 1 
20 1
HHPHPPHHPPHPPPHPHPHP
예제 출력 1 
8
예제 입력 2 
20 2
HHHHHPPPPPHPHPHPHHHP
예제 출력 2 
7
 */
package algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HamburgerDistribution {
    // 왼쪽부터 사람을 탐색해서 해당 위치 기준으로 K 범위 안에 햄버거 존재 여부 확인
    // 햄버거는 가장 왼쪽에 있는 것을 우선으로 하며 한번 찾은 위치는 배열에 기록
    // 이후 탐색시 찾은 햄버거 위치가 배열에서 true면 제외
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        String table = reader.readLine();
        boolean[] ate = new boolean[N];
        int count = 0;

        for (int personIdx = 0; personIdx < N; personIdx++) {
            if(isPerson(table, personIdx)) {
                if(distributable(table, personIdx, K, ate)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean distributable(String table, int personIdx, int k, boolean[] ate) {
        int left = Math.max(personIdx - k, 0);
        int right = Math.min(personIdx + k + 1, table.length());
        for (int i = left; i < right; i++) {
            if(!ate[i] && table.charAt(i) == 'H' && personIdx != i) {
                return ate[i] = true;
            }
        }
        return false;
    }

    private static boolean isPerson(String table, int i) {
        return table.charAt(i) == 'P';
    }
}
