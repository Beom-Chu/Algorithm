/*
타노스[20310] 서브태스크 다국어
시간 제한	메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
1 초	1024 MB	    3140	1428	1257	    49.645%
문제
어느 날, 타노스는 0과 1로 이루어진 문자열를 보았다.
신기하게도,가 포함하는 0의 개수와가 포함하는 1의 개수는 모두 짝수라고 한다.

갑자기 심술이 난 타노스는를 구성하는 문자 중 절반의 0과 절반의 1을 제거하여 새로운 문자열 S'를 만들고자 한다.
S'로 가능한 문자열 중 사전순으로 가장 빠른 것을 구하시오.

입력
문자열가 주어진다.

출력
로 가능한 문자열 중 사전순으로 가장 빠른 것을 출력한다.

제한
* S의 길이는 2 이상 500 이하이다.
* S는 짝수 개의 0과 짝수 개의 1로 이루어져 있다.
서브태스크 1 (25점)
* S의 길이는 4의 배수이다.
* S의 홀수 번째 문자는 1, 짝수 번째 문자는 0이다.
서브태스크 2 (75점)
* 추가적인 제약 조건이 없다.

예제 입력 1
1010
예제 출력 1
01
예제 입력 2
000011
예제 출력 2
001
 */
package algorithm.baekjoon.string;

import java.io.*;

public class Thanos {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        int one = 0;
        int zero = 0;
        StringBuilder sb = new StringBuilder();

        for (char chr : s.toCharArray()) {
            if(chr == '1') {
                one++;
            } else {
                zero++;
            }
            sb.append(chr);
        }

        one /= 2;
        zero /= 2;

        for (int i = 0; i < one; i++) {
            sb.deleteCharAt(sb.indexOf("1"));
        }
        for (int i = 0; i < zero; i++) {
            sb.deleteCharAt(sb.lastIndexOf("0"));
        }

        writer.write(sb.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
