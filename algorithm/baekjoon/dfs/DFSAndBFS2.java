/*
DFS와 BFS [1260]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	280237	109207	64863	37.649%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1
1 2 4 3
1 2 3 4
예제 입력 2
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2
3 1 2 5 4
3 1 4 2 5
예제 입력 3
1000 1 1000
999 1000
예제 출력 3
1000 999
1000 999
 */
package algorithm.baekjoon.dfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


public class DFSAndBFS2 {

    static StringJoiner bfs = new StringJoiner(" ");
    static StringJoiner dfs = new StringJoiner(" ");

    public static void main(String[] args) throws IOException {

        int n = readInt();
        int m = readInt();
        int v = readInt();
        HashMap<Integer, List<Integer>> connect = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            connect.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = readInt();
            int y = readInt();
            connect.get(x).add(y);
            connect.get(y).add(x);
        }

        dfs(connect, v, new boolean[n + 1]);
        bfs(connect, v, new boolean[n + 1]);

        print();
    }

    private static void print() throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(dfs));
        writer.write("\n");
        writer.write(String.valueOf(bfs));
        writer.flush();
        writer.close();
    }

    private static void dfs(HashMap<Integer, List<Integer>> connect, int v, boolean[] visit) {
        visit[v] = true;
        dfs.add(String.valueOf(v));
        List<Integer> vertexes = connect.get(v);
        vertexes.sort(Comparator.naturalOrder());

        for (Integer vertex : vertexes) {
            if(!visit[vertex]) {
                dfs(connect, vertex, visit);
            }
        }
    }

    private static void bfs(HashMap<Integer, List<Integer>> connect, int v, boolean[] visit) {
        Queue<Integer> que = new LinkedList<>();
        que.add(v);
        visit[v] = true;

        while(!que.isEmpty()) {
            Integer current = que.poll();
            List<Integer> vertexes = connect.get(current);
            vertexes.sort(Comparator.naturalOrder());

            for (Integer vertex : vertexes) {
                if(!visit[vertex]) {
                    que.add(vertex);
                    visit[vertex] = true;
                }
            }
            bfs.add(String.valueOf(current));
        }
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n')
            result = result * 10 + (chr - '0');
        return result;
    }
}
