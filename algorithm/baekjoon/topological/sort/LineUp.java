/* 줄 세우기 [2252]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	30046	17028	11196	55.188%
문제
N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.

일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)이 주어진다. M은 키를 비교한 회수이다. 다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.

학생들의 번호는 1번부터 N번이다.

출력
첫째 줄에 학생들을 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.

예제 입력 1
3 2
1 3
2 3
예제 출력 1
1 2 3
예제 입력 2
4 2
4 2
3 1
예제 출력 2
4 2 3 1
*/
package algorithm.baekjoon.topological.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        Map<Integer, List<Integer>> compare = new HashMap<>();
        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            compare.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            compare.get(a).add(b);
            inDegree[b]++;
        }

        List<Integer> result = topologicalSort(n, inDegree, compare);

        print(result);
    }


    public static List<Integer> topologicalSort(int n, int[] inDegree, Map<Integer, List<Integer>> compare) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
            }
        }

        while (!que.isEmpty()) {
            Integer current = que.poll();

            for (Integer next : compare.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.add(next);
                }
            }
            result.add(current);
        }
        return result;
    }


    private static void print(List<Integer> result) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            builder.append(result.get(i));
            if(i != result.size() - 1) {
                builder.append(" ");
            }
        }
        System.out.println(builder);
    }
}
