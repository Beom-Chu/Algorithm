/*
[18500]
미네랄 2
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	1814	608	470	34.738%
문제
창영과 상근은 한 동굴을 놓고 소유권을 주장하고 있다. 두 사람은 막대기를 서로에게 던지는 방법을 이용해 누구의 소유인지를 결정하기로 했다.
싸움은 동굴에서 벌어진다. 동굴에는 미네랄이 저장되어 있으며, 던진 막대기가 미네랄을 파괴할 수도 있다.

동굴은 R행 C열로 나타낼 수 있으며, R×C칸으로 이루어져 있다.
각 칸은 비어있거나 미네랄을 포함하고 있으며, 네 방향 중 하나로 인접한 미네랄이 포함된 두 칸은 같은 클러스터이다.

창영은 동굴의 왼쪽에 서있고, 상근은 오른쪽에 서있다. 두 사람은 턴을 번갈아가며 막대기를 던진다.
막대를 던지기 전에 던질 높이를 정해야 한다. 막대는 땅과 수평을 이루며 날아간다.

막대가 날아가다가 미네랄을 만나면, 그 칸에 있는 미네랄은 모두 파괴되고 막대는 그 자리에서 이동을 멈춘다.

미네랄이 파괴된 이후에 남은 클러스터가 분리될 수도 있다.
새롭게 생성된 클러스터가 떠 있는 경우에는 중력에 의해서 바닥으로 떨어지게 된다.
떨어지는 동안 클러스터의 모양은 변하지 않는다. 클러스터는 다른 클러스터나 땅을 만나기 전까지 게속해서 떨어진다.
클러스터는 다른 클러스터 위에 떨어질 수 있고, 그 이후에는 합쳐지게 된다.

동굴에 있는 미네랄의 모양과 두 사람이 던진 막대의 높이가 주어진다.
모든 막대를 던지고 난 이후에 미네랄 모양을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 동굴의 크기 R과 C가 주어진다. (1 ≤ R,C ≤ 100)

다음 R개 줄에는 C개의 문자가 주어지며, '.'는 빈 칸, 'x'는 미네랄을 나타낸다.

다음 줄에는 막대를 던진 횟수 N이 주어진다. (1 ≤ N ≤ 100)

마지막 줄에는 막대를 던진 높이가 주어지며, 공백으로 구분되어져 있다.
모든 높이는 1과 R사이이며, 높이 1은 행렬의 가장 바닥, R은 가장 위를 의미한다.
첫 번째 막대는 왼쪽에서 오른쪽으로 던졌으며, 두 번째는 오른쪽에서 왼쪽으로, 이와 같은 식으로 번갈아가며 던진다.

공중에 떠 있는 미네랄 클러스터는 없으며, 두 개 또는 그 이상의 클러스터가 동시에 떨어지는 경우도 없다.

출력
입력 형식과 같은 형식으로 미네랄 모양을 출력한다.

예제 입력 1
5 6
......
..xx..
..x...
..xx..
.xxxx.
1
3
예제 출력 1
......
......
..xx..
..xx..
.xxxx.
예제 입력 2
8 8
........
........
...x.xx.
...xxx..
..xxx...
..x.xxx.
..x...x.
.xxx..x.
5
6 6 4 3 1
예제 출력 2
........
........
........
........
.....x..
..xxxx..
..xxx.x.
..xxxxx.
예제 입력 3
7 6
......
......
xx....
.xx...
..xx..
...xx.
....x.
2
6 4
예제 출력 3
......
......
......
......
..xx..
xx.xx.
.x..x.
 */
package algorithm.baekjoon;

import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mineral2 {

    static int R, C;
    static boolean[][] cave;
    static int[][] rlud = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = reader.readLine();
            for (int j = 0; j < C; j++) {
                if(s.charAt(j) == 'x') {
                    cave[i][j] = true;
                }
            }
        }

        int N = Integer.parseInt(reader.readLine());
        int[] height = new int[N];
        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st2.nextToken());
        }


        for (int i = 0; i < height.length; i++) {
            attack(height[i], i % 2 == 0);
        }
    }

    /* 미네랄 공격 */
    static void attack(int h, boolean direction) {

        int attackR = R - h;
        int attackC = -1;

        if(direction) {
            for (int i = 0; i < C; i++) {
                if(cave[attackR][i]) {
                    attackC = i;
                    cave[attackR][i] = false;
                    break;
                }
            }
        } else {
            for (int i = C - 1; i >= 0 ; i--) {
                if(cave[attackR][i]) {
                    attackC = i;
                    cave[attackR][i] = false;
                    break;
                }
            }
        }
        
        for(boolean[] c : cave) {
            System.out.println("[[[Arrays.toString(c) = " + Arrays.toString(c));
        }

        Queue<Position> connectedMinerals = new LinkedList<>();

        /* 파괴된 미네랄과 연결 되어있던 미네랄 구하기 */
        for (int i = 0; i < 4; i++) {
            int connectR = attackR + rlud[i][0];
            int connectC = attackC + rlud[i][1];
            if(connectR >= 0 && connectR < R && connectC >= 0 && connectC < C && cave[connectR][connectC]) {
                connectedMinerals.add(new Position(connectR, connectC));
            }
        }

        for(Position p : connectedMinerals) {

            int emptySize = checkEmpty(p);
            System.out.println("r,c = "+ p.r +","+ p.c +"[[[checkEmpty(p) = " + emptySize);

            if(emptySize > 0) {
                drop(p, emptySize);
            }
        }
    }

    /* 클러스터를 아래로 이동 */
    static void drop(Position p, int emptySize) {

    }

    /* 떨어질수 있는 아래의 빈 공간 사이즈 구하기 */
    static int checkEmpty(Position p) {

        // TODO : Deep Copy 로 바꿔서..
        boolean[][] visit = Arrays.copyOf(cave, R);

        int emptyH = R;

        Queue<Position> que = new LinkedList<>();
        que.add(p);

        while(!que.isEmpty()) {
            Position currentP = que.poll();

            System.out.println("[[[currentP = " + currentP);

            if(currentP.r == R - 1) {
                emptyH = 0;
            }

            int tempR = currentP.r;
            int size = 0;
            while(tempR < R - 1 && emptyH != 0){
                tempR++;

                for(boolean[] c : cave) {
                    System.out.println("checkEmpty cave = " + Arrays.toString(c));
                }

                System.out.println("[[[tempR , currentP.c = " + tempR +", "+ currentP.c + " = " + cave[tempR][currentP.c]);

                if(cave[tempR][currentP.c]) {
                    break;
                } else {
                    size++;
                }
            }

            System.out.println("[[[size = " + size);

            if(size != 0) {
                emptyH = Math.min(emptyH, size);
            }

            for (int i = 0; i < 4; i++) {
                int nextR = currentP.r + rlud[i][0];
                int nextC = currentP.c + rlud[i][1];
                if(nextR >= 0 && nextR < R && nextC >= 0 && nextC < C && visit[nextR][nextC]) {
                    visit[nextR][nextC] = false;
                    que.add(new Position(nextR, nextC));
                }
            }
        }

        return emptyH;
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
