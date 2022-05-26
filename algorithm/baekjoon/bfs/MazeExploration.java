package algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
미로 탐색 [2178]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	122971	51779	33271	40.860%
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다.
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

예제 입력 1
4 6
101111
101010
101011
111011
예제 출력 1
15
예제 입력 2
4 6
110110
110110
111111
111101
예제 출력 2
9
예제 입력 3
2 25
1011101110111011101110111
1110111011101110111011101
예제 출력 3
38
예제 입력 4
7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
예제 출력 4
13
 */
public class MazeExploration {
    public static void main(String[] args) throws IOException {

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr)) {

            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[][] maze = new boolean[n][m];
            int[][] distance = new int[n][m];
            Queue<Integer[]> que = new LinkedList<>();

            /* 이동 방향 */
            int[] iMove = new int[]{0, 1, 0, -1};
            int[] jMove = new int[]{1, 0, -1, 0};

            /* 미로 만들기 */
            makeMaze(reader, n, m, maze);

            /* 출발지 설정 */
            que.add(new Integer[]{0,0});
            distance[0][0] = 1;
            maze[0][0] = false;

            while (!que.isEmpty()) {
                Integer[] location = que.poll();
                int i = location[0];
                int j = location[1];

                if(i == n && j == m) {
                    break;
                }

                for (int k = 0; k < 4; k++) {

                    int i2 = i + iMove[k];
                    int j2 = j + jMove[k];

                    /* 갈 수 없는 위치 제외 */
                    if(i2 < 0 || j2 < 0 || i2 >= n || j2 >= m) {
                        continue;
                    }
                    if(maze[i2][j2]) {
                        que.add(new Integer[]{i2, j2});
                        distance[i2][j2] = distance[i][j] + 1;
                        maze[i2][j2] = false;
                    }
                }

            }

            System.out.println(distance[n-1][m-1]);
        }
    }

    /* 미로 만들기 */
    public static void makeMaze(BufferedReader reader, int n, int m, boolean[][] maze) throws IOException {
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = (s.charAt(j) == '1');
            }
        }
    }
}
