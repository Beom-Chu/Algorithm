/*
새로운 게임[17780]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초	512 MB	2436	1159	869	47.434%
문제
재현이는 주변을 살펴보던 중 체스판과 말을 이용해서 새로운 게임을 만들기로 했다.
새로운 게임은 크기가 N×N인 체스판에서 진행되고, 사용하는 말의 개수는 K개이다.
말은 원판모양이고, 하나의 말 위에 다른 말을 올릴 수 있다. 체스판의 각 칸은 흰색, 빨간색, 파란색 중 하나로 색칠되어있다.

게임은 체스판 위에 말 K개를 놓고 시작한다. 말은 1번부터 K번까지 번호가 매겨져 있고,
이동 방향도 미리 정해져 있다. 이동 방향은 위, 아래, 왼쪽, 오른쪽 4가지 중 하나이다.

턴 한 번은 1번 말부터 K번 말까지 순서대로 이동시키는 것이다.
한 말이 이동할 때 위에 올려져 있는 말도 함께 이동하며, 가장 아래에 있는 말만 이동할 수 있다.
말의 이동 방향에 있는 칸에 따라서 말의 이동이 다르며 아래와 같다. 턴이 진행되던 중에 말이 4개 이상 쌓이는 순간 게임이 종료된다.

A번 말이 이동하려는 칸이
흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다.
방향을 반대로 한 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 방향만 반대로 바꾼다.
체스판을 벗어나는 경우에는 파란색과 같은 경우이다.
다음은 크기가 4×4인 체스판 위에 말이 4개 있는 경우이다.



첫 번째 턴은 다음과 같이 진행된다.


두 번째 턴은 다음과 같이 진행된다.


체스판의 크기와 말의 위치, 이동 방향이 모두 주어졌을 때, 게임이 종료되는 턴의 번호를 구해보자.

입력
첫째 줄에 체스판의 크기 N, 말의 개수 K가 주어진다.
둘째 줄부터 N개의 줄에 체스판의 정보가 주어진다.
체스판의 정보는 정수로 이루어져 있고, 각 정수는 칸의 색을 의미한다. 0은 흰색, 1은 빨간색, 2는 파란색이다.

다음 K개의 줄에 말의 정보가 1번 말부터 순서대로 주어진다.
말의 정보는 세 개의 정수로 이루어져 있고, 순서대로 행, 열의 번호, 이동 방향이다.
행과 열의 번호는 1부터 시작하고, 이동 방향은 4보다 작거나 같은 자연수이고 1부터 순서대로 →, ←, ↑, ↓의 의미를 갖는다.

같은 칸에 말이 두 개 이상 있는 경우는 입력으로 주어지지 않는다.

출력
게임이 종료되는 턴의 번호를 출력한다. 그 값이 1,000보다 크거나 절대로 게임이 종료되지 않는 경우에는 -1을 출력한다.

제한
4 ≤ N ≤ 12
4 ≤ K ≤ 10
예제 입력 1
4 4
0 0 2 0
0 0 1 0
0 0 1 2
0 2 0 0
2 1 1
3 2 3
2 2 1
4 1 2
예제 출력 1
-1
예제 입력 2
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
1 1 1
1 2 1
1 3 1
1 4 1
예제 출력 2
1
예제 입력 3
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
1 1 1
1 2 1
1 3 1
2 4 3
예제 출력 3
1
예제 입력 4
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
1 1 1
1 2 1
1 3 1
3 3 3
예제 출력 4
2
예제 입력 5
4 4
0 0 2 0
0 0 1 0
0 0 1 2
0 2 0 0
2 1 1
3 2 3
2 2 1
4 1 3
예제 출력 5
8
예제 입력 6
6 10
0 1 2 0 1 1
1 2 0 1 1 0
2 1 0 1 1 0
1 0 1 1 0 2
2 0 1 2 0 1
0 2 1 0 2 1
1 1 1
2 2 2
3 3 4
4 4 1
5 5 3
6 6 2
1 6 3
6 1 2
2 4 3
4 2 1
예제 출력 6
9
 */
package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NewGame {

    static int N;
    static int[][] board;
    static List<Horse> horses;
    static int[][] direction = {{0, 0},{0, 1},{0, -1},{-1, 0},{1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        horses = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 1; i <= K; i++) {
            horses.add(new Horse(reader.readLine(), i));
        }

        for (int i = 0; i < 1000; i++) {

            for(Horse h : horses) {
                if(h.height != 0) {continue;}

                if(move(h)) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    static public boolean move(Horse h) {

        int max = 0;
        int curR = h.r;
        int curC = h.c;
        int moveR = curR + direction[h.d][0];
        int moveC = curC + direction[h.d][1];

        // 이동 위치로 갈 수 없거나 파란칸인 경우
        if(moveR > N || moveR < 1 || moveC > N || moveC < 1 || board[moveR][moveC] == 2) {

            h.d += h.d % 2 == 1 ? 1 : -1;
            moveR = curR + direction[h.d][0];
            moveC = curC + direction[h.d][1];

            // 반대 방향으로 이동할 위치로 갈수 없거나 파란칸이면 방향만 바꾼채로 이동 안함
            if(moveR > N || moveR < 1 || moveC > N || moveC < 1 || board[moveR][moveC] == 2) {
                return false;
            }
        }

        // 같은 위치의 말 개수, 이동할 위치의 말 개수
        int sameLocCnt = 0, moveLocCnt = 0;
        for(Horse horse : horses) {
            if(curR == horse.r && curC == horse.c) {
                sameLocCnt++;
            }
            if(moveR == horse.r && moveC == horse.c){
                moveLocCnt++;
            }
        }

        // 말 위치 변경
        for(Horse horse : horses) {
            if(curR == horse.r && curC == horse.c) {
                horse.r = moveR;
                horse.c = moveC;

                reverse(horse, sameLocCnt, moveLocCnt);
                max = Math.max(max, horse.height);
            }
        }

        return max >= 3;
    }

    // 빨간칸 : 업은 말 위치 변경
    public static void reverse(Horse h, int sameLocCnt, int moveLocCnt){
        // 빨간칸인 경우 업은 말 높이 변경
        if (board[h.r][h.c] == 1) {
            h.height = sameLocCnt - h.height - 1;
        }

        // 이동할 칸에 말들이 있는 경우 그 수만큼 높이 올리기
        if(moveLocCnt > 0) {
            h.height += moveLocCnt;
        }
    }

    static class Horse {
        int i;
        int r;
        int c;
        int d;
        int height;

        public Horse(String s, int i) {
            this.i = i;
            String[] as = s.split(" ");
            this.r = Integer.parseInt(as[0]);
            this.c = Integer.parseInt(as[1]);
            this.d = Integer.parseInt(as[2]);
            this.height = 0;
        }

        @Override
        public String toString() {
            return "Horse{" +
                    "i=" + i +
                    ", r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", height=" + height +
                    '}';
        }
    }
}
