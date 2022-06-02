/*
DSLR [9019] 스페셜 저지 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
6 초	256 MB	47812	11884	7528	21.195%
문제
네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다. 이 계산기에는 레지스터가 하나 있는데,
 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다. 각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다.
 n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)

D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다.
그 결과 값(2n mod 10000)을 레지스터에 저장한다.
S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다.
n이 0 이라면 9999 가 대신 레지스터에 저장된다.
L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다.
이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다.
이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다.
예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.

여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다.
예를 들어서 A = 1234, B = 3412 라면 다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.

1234 →L 2341 →L 3412
1234 →R 4123 →R 3412

따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.

n의 자릿수로 0 이 포함된 경우에 주의해야 한다.
예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다.
그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.

입력
프로그램 입력은 T 개의 테스트 케이스로 구성된다.
테스트 케이스 개수 T 는 입력의 첫 줄에 주어진다.
각 테스트 케이스로는 두 개의 정수 A와 B(A ≠ B)가 공백으로 분리되어 차례로 주어지는데 A는 레지스터의 초기 값을 나타내고 B는 최종 값을 나타낸다.
A 와 B는 모두 0 이상 10,000 미만이다.

출력
A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다.
가능한 명령어 나열이 여러가지면, 아무거나 출력한다.

예제 입력 1
3
1234 3412
1000 1
1 16
예제 출력 1
LL
L
DDDD

메모리 초과 방지를 위해 visited 사용
시간초과 방지를 위해 calculation 에 문자열 미사용
*/
package algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DSLR {

    public static String[] commands = {"D", "S", "L", "R"};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tCount = Integer.parseInt(reader.readLine());
        List<TestCase> testCaseList = new ArrayList<>();
        for (int i = 0; i < tCount; i++) {
            testCaseList.add(new TestCase(reader.readLine()));
        }

        for (TestCase tc : testCaseList) {
            minimalCommand(tc);
        }
    }

    private static void minimalCommand(TestCase tc) {
        Queue<Register> que = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        que.add(new Register(tc.before, ""));
        visited[tc.before] = true;

        while (!que.isEmpty()) {
            Register current = que.poll();
            if (current.number == tc.after) {
                System.out.println(current.command);
                break;
            }

            for (String command : commands) {
                int cal = calculation(current.number, command);
                if (!visited[cal]) {
                    que.add(new Register(cal, current.command + command));
                    visited[cal] = true;
                }
            }
        }
    }

    public static int calculation(int before, String command) {
        switch (command) {
            case "D":
                return before * 2 % 10000;
            case "S":
                return before == 0 ? 9999 : before - 1;
            case "L":
                return (before % 1000) * 10 + before / 1000;
            default:
                return (before % 10) * 1000 + before / 10;
        }
    }

    public static class TestCase {
        int before;
        int after;

        public TestCase(String readLine) {
            StringTokenizer st = new StringTokenizer(readLine);
            this.before = Integer.parseInt(st.nextToken());
            this.after = Integer.parseInt(st.nextToken());
        }
    }

    public static class Register {
        int number;
        String command;

        public Register(int number, String command) {
            this.number = number;
            this.command = command;
        }
    }
}