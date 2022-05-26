package algorithm.baekjoon;

/* 바이러스 [2606]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	98510	46789	31587	45.823%
문제
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.

1-2-3  4
|/    /
5-6  7

어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

예제 입력 1
7
6
1 2
2 3
1 5
5 2
5 6
4 7
예제 출력 1
4
예제 입력 2
10
7
1 2
2 3
3 4
5 6
7 8
8 9
9 1
예제 출력 2
6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {

    public static Integer count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int pcCount = Integer.parseInt(reader.readLine());
        int connectCount = Integer.parseInt(reader.readLine());
        boolean[] visit = new boolean[pcCount + 1]; /* PC번호 1번부터이므로 + 1 */

        /* 네트워크 정보 설정 */
        int[][] network = setNetwork(reader, connectCount);

        /* 바이러스 체크 */
        checkVirus(network, 1, visit);

        System.out.println(count - 1); /* 1번 PC 제외 : -1 */

    }

    /* 네트워크 정보 설정 */
    private static int[][] setNetwork(BufferedReader reader, int connectCount) throws IOException {

        int[][] network = new int[connectCount][2];

        for(int[] connection : network) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            connection[0] = Integer.parseInt(st.nextToken());
            connection[1] = Integer.parseInt(st.nextToken());
        }
        return network;
    }

    /* 바이러스 체크 */
    private static void checkVirus(int[][] network, int pc, boolean[] visit) {

        visit[pc] = true;
        count++;

        for (int[] connection : network) {
            for (int i = 0; i < 2; i++) {
                if (connection[i] == pc && !visit[connection[1-i]]) {
                    checkVirus(network, connection[1-i], visit);
                }
            }
        }
    }
}
