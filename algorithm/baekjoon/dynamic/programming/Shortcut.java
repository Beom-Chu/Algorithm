/*
지름길[1446]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	10474	5859	4462	56.381%

문제
매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다.
이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다.
어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다.
모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.

세준이가 운전해야 하는 거리의 최솟값을 출력하시오.

입력
첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다.
N은 12 이하인 양의 정수이고, D는 10,000보다 작거나 같은 자연수이다.
다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다.
모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다.
지름길의 시작 위치는 도착 위치보다 작다.

출력
세준이가 운전해야하는 거리의 최솟값을 출력하시오.

예제 입력 1
5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90
예제 출력 1
70
예제 입력 2
2 100
10 60 40
50 90 20
예제 출력 2
80
예제 입력 3
8 900
0 10 9
20 60 45
80 190 100
50 70 15
160 180 14
140 160 14
420 901 5
450 900 0
예제 출력 3
432
 */
package algorithm.baekjoon.dynamic.programming;

import java.io.IOException;
import java.util.*;

public class Shortcut {

    static int[] distance;
    static Map<Integer, Map<Integer, Integer>> shortcuts;

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int d = readInt();
        shortcuts = new HashMap<>();
        distance = new int[d + 1];

        for (int i = 0; i < n; i++) {
            int from = readInt();
            int to = readInt();
            int shotDis = readInt();

            if (to - from > shotDis) {
                if (!shortcuts.containsKey(to)) {
                    shortcuts.put(to, new HashMap<>());
                }
                if (!shortcuts.get(to).containsKey(from)) {
                    shortcuts.get(to).put(from, shotDis);
                } else {
                    shortcuts.get(to).put(from, Math.min(shotDis, shortcuts.get(to).get(from)));
                }
            }
        }

        System.out.println(findDistance(d));
    }

    static int findDistance(int n) {
        if(n == 0) {
            return 0;
        }

        if(distance[n] != 0) {
            return distance[n];
        }

        distance[n] = findDistance(n - 1) + 1;

        if(shortcuts.containsKey(n)) {
            for (Map.Entry<Integer, Integer> e : shortcuts.get(n).entrySet()) {
                distance[n] = Math.min(distance[n], distance[e.getKey()] + e.getValue());
            }
        }
        return distance[n];
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n')
            result = result * 10 + (chr - '0');
        return result;
    }
}