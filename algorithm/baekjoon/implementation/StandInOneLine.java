/*
한 줄로 서기 [1138]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	14528	8781	7333	61.073%
문제
N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.

어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다.
그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.

사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.
N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.

각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N이 주어진다. N은 10보다 작거나 같은 자연수이다.
둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.
i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.

출력
첫째 줄에 줄을 선 순서대로 키를 출력한다.

예제 입력 1
4
2 1 1 0
예제 출력 1
4 2 1 3
예제 입력 2
5
0 0 0 0 0
예제 출력 2
1 2 3 4 5
예제 입력 3
6
5 4 3 2 1 0
예제 출력 3
6 5 4 3 2 1
예제 입력 4
7
6 1 1 1 2 0 0
예제 출력 4
6 2 3 4 7 5 1

 */
package algorithm.baekjoon.implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringJoiner;


public class StandInOneLine {
    // 뒷 번호부터 List에 등록하는데, 입력된 숫자만큼 본인보다 큰 숫자들의 뒤에 등록
    public static void main(String[] args) throws IOException {

        int n = readInt();
        int[] memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = readInt();
        }

        List<Integer> list = new LinkedList<>();

        for (int i = memory.length - 1; i >= 0; i--) {
            int num = i + 1;
            int m = memory[i];
            ListIterator<Integer> iterator = list.listIterator();

            while (iterator.hasNext()) {
                if (m == 0) {
                    break;
                }
                if (iterator.next() > num) {
                    m--;
                }
            }
            iterator.add(num);
        }
        print(list);
    }

    private static void print(List<Integer> list) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringJoiner joiner = new StringJoiner(" ");
        for (Integer num : list) {
            joiner.add(String.valueOf(num));
        }
        writer.write(joiner.toString());
        writer.flush();
        writer.close();
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n') {
            result = result * 10 + (chr - '0');
        }
        return result;
    }
}
