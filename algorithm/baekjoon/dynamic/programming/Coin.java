/*
동전[9084]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	7515	4813	3984	65.333%
문제
우리나라 화폐단위, 특히 동전에는 1원, 5원, 10원, 50원, 100원, 500원이 있다.
이 동전들로는 정수의 금액을 만들 수 있으며 그 방법도 여러 가지가 있을 수 있다.
예를 들어, 30원을 만들기 위해서는 1원짜리 30개 또는 10원짜리 2개와 5원짜리 2개 등의 방법이 가능하다.

동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하시오.

입력
입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고 두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다.
각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다.
세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.

편의를 위해 방법의 수는 231 - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.

출력
각 테스트 케이스에 대해 입력으로 주어지는 N가지 동전으로 금액 M을 만드는 모든 방법의 수를 한 줄에 하나씩 출력한다.

예제 입력 1
3
2
1 2
1000
3
1 5 10
100
2
5 7
22
예제 출력 1
501
121
1
 */
package algorithm.baekjoon.dynamic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Coin {

    public static void main(String[] args) throws IOException {
        List<TestCase> testCases = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            TestCase tc = new TestCase();
            tc.N = Integer.parseInt(reader.readLine());
            tc.coins = new int[tc.N];
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < tc.N; j++) {
                tc.coins[j] = Integer.parseInt(st.nextToken());
            }
            tc.M = Integer.parseInt(reader.readLine());
            testCases.add(tc);
        }

        for (TestCase tc : testCases) {
            int[] dp = new int[tc.M + 1];
            dp[0] = 1;
            for (int i = 0; i < tc.N; i++) {
                for (int j = tc.coins[i]; j <= tc.M; j++) {
                    dp[j] += dp[j - tc.coins[i]];
                }
            }
            System.out.println(dp[tc.M]);
        }
    }


    static class TestCase {
        int N, M;
        int[] coins;

        @Override
        public String toString() {
            return "TestCase{" +
                    "N=" + N +
                    ", M=" + M +
                    ", coins=" + Arrays.toString(coins) +
                    '}';
        }
    }
}
