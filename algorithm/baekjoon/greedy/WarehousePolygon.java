/*
창고 다각형 [2304]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	16598	6930	5418	41.903%
문제
N 개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다.
이 기둥들을 이용하여 양철로 된 창고를 제작하려고 한다. 창고에는 모든 기둥이 들어간다.
이 창고의 지붕을 다음과 같이 만든다.

지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
지붕의 가장자리는 땅에 닿아야 한다.
비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.

그림 1은 창고를 옆에서 본 모습을 그린 것이다.
이 그림에서 굵은 선으로 표시된 부분이 지붕에 해당되고, 지붕과 땅으로 둘러싸인 다각형이 창고를 옆에서 본 모습이다.
이 다각형을 창고 다각형이라고 하자.



그림1 . 기둥과 지붕(굵은 선)의 예

창고 주인은 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다.
그림 1에서 창고 다각형의 면적은 98 ㎡이고, 이 경우가 가장 작은 창고 다각형이다.

기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.

입력
첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다.
그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다.
L과 H는 둘 다 1 이상 1,000 이하이다.

출력
첫 줄에 창고 다각형의 면적을 나타내는 정수를 출력한다.

예제 입력 1
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6
예제 출력 1
98
 */
package algorithm.baekjoon.greedy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WarehousePolygon {

    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = readInt();
        int[] pillars = new int[1001];
        int highestPillarH = 0, highestPillarL = 0;

        for (int i = 0; i < n; i++) {
            int l = readInt();
            int h = readInt();
            pillars[l] = h;
            if (highestPillarH < h) {
                highestPillarL = l;
                highestPillarH = h;
            }
        }

        int beforeH = 0;
        int result = highestPillarH;

        for (int i = 0; i < highestPillarL; i++) {
            beforeH = Math.max(beforeH, pillars[i]);
            result += beforeH;
        }

        beforeH = 0;

        for (int i = 1000; highestPillarL < i; i--) {
            beforeH = Math.max(beforeH, pillars[i]);
            result += beforeH;
        }

        writer.write(String.valueOf(result));
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
