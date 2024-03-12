/*
진우의 달 여행 (Small)[17484]
시간 제한	메모리 제한	제출	    정답	    맞힌 사람	정답  비율
1 초	256 MB	    2720	1531	1285	58.515%
문제
우주비행이 꿈이였던 진우는 음식점 '매일매일싱싱'에서 열심히 일한 결과 달 여행에 필요한 자금을 모두 마련하였다!
지구와 우주사이는 N X M 행렬로 나타낼 수 있으며 각 원소의 값은 우주선이 그 공간을 지날 때 소모되는 연료의 양이다.

[예시]

진우는 여행경비를 아끼기 위해 조금 특이한 우주선을 선택하였다.
진우가 선택한 우주선의 특징은 아래와 같다.

1. 지구 -> 달로 가는 경우 우주선이 움직일 수 있는 방향은 아래와 같다.
 / | \

2. 우주선은 전에 움직인 방향으로 움직일 수 없다. 즉, 같은 방향으로 두번 연속으로 움직일 수 없다.

진우의 목표는 연료를 최대한 아끼며 지구의 어느위치에서든 출발하여 달의 어느위치든 착륙하는 것이다.
최대한 돈을 아끼고 살아서 달에 도착하고 싶은 진우를 위해 달에 도달하기 위해 필요한 연료의 최소값을 계산해 주자.

입력
첫줄에 지구와 달 사이 공간을 나타내는 행렬의 크기를 나타내는 N, M (2≤ N, M ≤ 6)이 주어진다.
다음 N줄 동안 각 행렬의 원소 값이 주어진다. 각 행렬의 원소값은 100 이하의 자연수이다.

출력
달 여행에 필요한 최소 연료의 값을 출력한다.

예제 입력 1
6 4
5 8 5 1
3 5 8 4
9 77 65 5
2 1 5 2
5 98 1 5
4 95 67 58
예제 출력 1
29
 */
package algorithm.baekjoon.dynamic.programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TripToTheMoon {
    static int[][] space, optimal, prevDirection;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        setSpace(reader, n, m);
        optimal = new int[n][m];
        prevDirection = new int[n][m];

        System.arraycopy(space[0], 0, optimal[0], 0, m);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                findOptimal(i, j, m);
            }
        }

        System.out.println(
                Arrays.stream(optimal[optimal.length - 1])
                        .min().getAsInt());
    }

    private static void findOptimal(int i, int j, int m) {
        int add = space[i][j];
        int left = Integer.MAX_VALUE, center = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if ((j - 1 >= 0) && prevDirection[i - 1][j - 1] != 1) {
            left = optimal[i - 1][j - 1] + add;
        }
        if (prevDirection[i - 1][j] != 2) {
            center = optimal[i - 1][j] + add;
        }
        if ((j + 1 < m) && prevDirection[i - 1][j + 1] != 3) {
            right = optimal[i - 1][j + 1] + add;
        }

        if (left <= center && left <= right) {
            optimal[i][j] = left;
            prevDirection[i][j] = 1;
        } else if (center <= left && center <= right) {
            optimal[i][j] = center;
            prevDirection[i][j] = 2;
        } else {
            optimal[i][j] = right;
            prevDirection[i][j] = 3;
        }

        if (center == left || right == center || left == right) {
            prevDirection[i][j] = 0;
        }
    }

    private static void setSpace(BufferedReader reader, int n, int m) throws IOException {
        space = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                space[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}
