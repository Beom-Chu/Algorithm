package algorithm.baekjoon.math;

/*
돌 게임[9655]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	27191	18039	15367	67.302%
문제
돌 게임은 두 명이서 즐기는 재밌는 게임이다.

탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다.
마지막 돌을 가져가는 사람이 게임을 이기게 된다.

두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1000)

출력
상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.

예제 입력 1
5
예제 출력 1
SK

결국 홀수면 상근이, 짝수면 창영이가 이긴다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoneGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        System.out.println((n % 2 == 0) ? "CY" : "SK");
    }
}
