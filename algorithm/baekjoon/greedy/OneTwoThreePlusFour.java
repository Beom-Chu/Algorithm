/*
1, 2, 3 더하기 4 [15989]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초 (추가 시간 없음)	512 MB	9115	5822	4652	64.602%
문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 4가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다. 합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.

1+1+1+1
2+1+1 (1+1+2, 1+2+1)
2+2
1+3 (3+1)
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 10,000보다 작거나 같다.

출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

예제 입력 1
3
4
7
10
예제 출력 1
4
8
14
 */
package algorithm.baekjoon.greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OneTwoThreePlusFour {
    static List<Number> res;

    public static void main(String[] args) throws IOException {
        int t = readInt();
        int[] nums = new int[t];
        for (int i = 0; i < t; i++) {
            nums[i] = readInt();
        }

        for (int num : nums) {
            solution(num);
        }
    }

    private static void solution(int num) {
        res = new ArrayList<>();
        recursion(new Number(0,0,0), num);
        System.out.println(res.size());
        for (Number re : res) {
            System.out.println(re);
        }
    }

    private static void recursion(Number sum, int num) {

        if (sum.getSum() == num) {
            if(!res.contains(sum)) {
                res.add(sum);
            }
            return;
        } else if (sum.getSum() > num) {
            return;
        }
        recursion(new Number(sum.one+1, sum.two, sum.three), num);
        recursion(new Number(sum.one, sum.two+1, sum.three), num);
        recursion(new Number(sum.one, sum.two, sum.three+1), num);
    }

    static class Number {
        int one, two, three;

        int getSum() {
            return one + (2 * two) + (3 * three);
        }

        public Number(int one, int three, int two) {
            this.one = one;
            this.three = three;
            this.two = two;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Number number = (Number) o;
            return one == number.one && two == number.two && three == number.three;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "one=" + one +
                    ", two=" + two +
                    ", three=" + three +
                    '}';
        }
    }

    public static int readInt() throws IOException {
        int chr, result = 0;
        while ((chr = System.in.read()) != ' ' && chr != '\n')
            result = result * 10 + (chr - '0');
        return result;
    }
}
