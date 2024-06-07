/*
문자열 교환[1522]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	3174	1711	1449	56.272%
문제
a와 b로만 이루어진 문자열이 주어질 때,  a를 모두 연속으로 만들기 위해서 필요한 교환의 회수를 최소로 하는 프로그램을 작성하시오.

이 문자열은 원형이기 때문에, 처음과 끝은 서로 인접해 있는 것이다.

예를 들어,  aabbaaabaaba이 주어졌을 때, 2번의 교환이면 a를 모두 연속으로 만들 수 있다.

입력
첫째 줄에 문자열이 주어진다. 문자열의 길이는 최대 1,000이다.

출력
첫째 줄에 필요한 교환의 회수의 최솟값을 출력한다.

예제 입력 1
abababababababa
예제 출력 1
3
예제 입력 2
ba
예제 출력 2
0
예제 입력 3
aaaabbbbba
예제 출력 3
0
예제 입력 4
abab
예제 출력 4
1
예제 입력 5
aabbaaabaaba
예제 출력 5
2
예제 입력 6
aaaa
예제 출력 6
0
 */
package algorithm.baekjoon.sliding.window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExchange {
    // a 전체 개수만큼의 윈도우를 이동시키면서
    // 가장 많은 수의 a를 가진 범위를 구하면
    // 그 범위에서 b의 수만큼이 교환 최소값이다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.replace("b", "").length();
        int currentCount = str.substring(0, size).replace("b", "").length();
        int left = 0;
        int right = size;
        int maxCount = 0;

        str += str;

        while (right < str.length()) {
            if (str.charAt(left) == 'a') {
                currentCount--;
            }
            if (str.charAt(right) == 'a') {
                currentCount++;
            }
            maxCount = Math.max(maxCount, currentCount);
            left++;
            right++;
        }

        System.out.println(size - maxCount);
    }
}
