/*
쉬운 최단거리 [14940]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	25315	10011	8165	37.176%

문제

지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.

입력
지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
다음 n개의 줄에 m개의 숫자가 주어진다.
0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다.
입력에서 2는 단 한개이다.

출력
각 지점에서 목표지점까지의 거리를 출력한다.
원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.

예제 입력 1
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
예제 출력 1
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
11 12 13 14 15 16 17 18 19 20 0 0 0 0 25
12 13 14 15 16 17 18 19 20 21 0 29 28 27 26
13 14 15 16 17 18 19 20 21 22 0 30 0 0 0
14 15 16 17 18 19 20 21 22 23 0 31 32 33 34
 */
package algorithm.baekjoon.dynamic.programming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class EasyShortestDistance {

    static int n, m;
    static int[][] map, dp;
    static int[] moveX = {+1, 0, -1, 0};
    static int[] moveY = {0, +1, 0, -1};
    static boolean[][] visit, check;

    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();
        map = new int[n][m];
        dp = new int[n][m];
        visit = new boolean[n][m];
        check = new boolean[n][m];

        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int no = readInt();
                map[i][j] = no;
                if (no == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        solution(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!check[i][j] && map[i][j] == 1) {
                    dp[i][j] = -1;
                }
            }
        }

        print(dp);
    }

    private static void solution(int x, int y) {

        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{x, y});
        visit[x][y] = true;

        while (!que.isEmpty()) {
            Integer[] xy = que.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = xy[0] + moveX[i];
                int nextY = xy[1] + moveY[i];
                if (nextX >= 0 && nextY >= 0 && nextX <= n - 1 && nextY <= m - 1) {
                    check[nextX][nextY] = true;
                    if (map[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                        dp[nextX][nextY] = dp[xy[0]][xy[1]] + 1;
                        que.add(new Integer[]{nextX, nextY});
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    private static void print(int[][] dp) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int[] d1 : dp) {
            StringJoiner joiner = new StringJoiner(" ");
            for (int d2 : d1) {
                joiner.add(String.valueOf(d2));
            }
            writer.write(joiner.toString());
            writer.write("\n");
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