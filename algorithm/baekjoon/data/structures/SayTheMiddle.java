/*
가운데를 말해요 [1655]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.1 초 (하단 참고)	128 MB	40795	11907	8985	30.812%
문제
백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다.
백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.
만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.

예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면, 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.
백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다. N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.
그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다. 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.

출력
한 줄에 하나씩 N줄에 걸쳐 백준이의 동생이 말해야 하는 수를 순서대로 출력한다.

예제 입력 1
7
1
5
2
10
-99
7
5
예제 출력 1
1
1
2
2
2
2
5
 */
package algorithm.baekjoon.data.structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SayTheMiddle {

    /*
    시간 초과가 안되기 위해서
    for문을 하나만 쓰도록 고치고
    list를 사용하지 않았고
    결과값을 StringBuilder에 모아서 한번에 출력
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> up = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> down = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(reader.readLine());

            if(down.isEmpty()) {
                down.add(number);
            } else {
                if(down.size() > up.size()) {
                    up.add(number);
                } else {
                    down.add(number);
                }

                if(down.peek() > up.peek()) {
                    int d = down.poll();
                    int u = up.poll();
                    up.add(d);
                    down.add(u);
                }
            }
            sb.append(down.peek()).append("\n");
        }
        System.out.println(sb);
    }

    /* 시간초과... */
    public static void main2(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N];
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < N; i++) {
            list.add(numbers[i]);
            list.sort(Comparator.naturalOrder());
            System.out.println(list.get(list.size() / 2 - i % 2));
        }
    }
}
