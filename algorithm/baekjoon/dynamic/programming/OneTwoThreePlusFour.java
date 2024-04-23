/*
1, 2, 3 더하기 4 [15989]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (추가 시간 없음)	512 MB	9115	5822	4652	64.602%
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 4가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.

1+1+1+1
2+1+1 (1+1+2, 1+2+1)
2+2
1+3 (3+1)
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 10,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1
3
4
7
10
예제 출력 1
4
8
14
 */
package algorithm.baekjoon.dynamic.programming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OneTwoThreePlusFour {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        int[] nums = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            nums[i] = readInt();
            max = Math.max(max, nums[i]) + 1;
        }
        dp = new int[max][4];

        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i < max; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            writer.write(String.valueOf(dp[nums[i]][1] + dp[nums[i]][2] + dp[nums[i]][3]));
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n')
            result = result * 10 + (chr - '0');
        return result;
    }
}
