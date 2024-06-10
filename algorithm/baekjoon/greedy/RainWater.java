/*
빗물[14719]
시간 제한	메모리 제한	제출	    정답	    맞힌 사람	정답 비율
1 초	    256 MB	    19867	11294	8828	    56.896%
문제
2차원 세계에 블록이 쌓여있다. 비가 오면 블록 사이에 빗물이 고인다.

비는 충분히 많이 온다. 고이는 빗물의 총량은 얼마일까?

입력
첫 번째 줄에는 2차원 세계의 세로 길이 H과 2차원 세계의 가로 길이 W가 주어진다. (1 ≤ H, W ≤ 500)

두 번째 줄에는 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개 주어진다.

따라서 블록 내부의 빈 공간이 생길 수 없다. 또 2차원 세계의 바닥은 항상 막혀있다고 가정하여도 좋다.

출력
2차원 세계에서는 한 칸의 용량은 1이다. 고이는 빗물의 총량을 출력하여라.

빗물이 전혀 고이지 않을 경우 0을 출력하여라.

예제 입력 1
4 4
3 0 1 4
예제 출력 1
5
예제 입력 2
4 8
3 1 2 3 4 1 1 2
예제 출력 2
5
예제 입력 3
3 5
0 0 0 2 0
예제 출력 3
0
 */
package algorithm.baekjoon.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
가장 높은 높이값부터 감소시키며 일치하는게 2곳 이상인 곳을 찾는다.
두 곳의 사이에 해당하는 값이 두 높이보다 작으면 그 수만큼을 더한다.
높이값을 낮추며 반복한다.
 */
public class RainWater {
    public static void main(String[] args) throws IOException {
        int h = readInt();
        int w = readInt();
        int[] blocks = new int[w];
        int max = 0;
        for (int i = 0; i < w; i++) {
            blocks[i] = readInt();
            max = Math.max(max, blocks[i]);
        }

        int result = 0;

        while (max > 0) {
            List<Integer> n = new ArrayList<>();
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] >= max) {
                    n.add(i);
                }
            }
            if (n.size() > 1) {
                int before = n.get(0);
                for (int i = 1; i < n.size(); i++) {
                    result += n.get(i) - before - 1;
                    before = n.get(i);
                }
            }
            max--;
        }

        System.out.println(result);
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n')
            result = result * 10 + (chr - '0');
        return result;
    }
}
