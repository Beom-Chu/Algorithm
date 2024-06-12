/*
A와 B 2[12919]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	14313	4694	3742	31.607%
문제
수빈이는 A와 B로만 이루어진 영어 단어 존재한다는 사실에 놀랐다.
대표적인 예로 AB (Abdominal의 약자), BAA (양의 울음 소리), AA (용암의 종류), ABBA (스웨덴 팝 그룹)이 있다.

이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다.
두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다.
문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.

문자열의 뒤에 A를 추가한다.
문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)

출력
S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.

예제 입력 1
A
BABA
예제 출력 1
1
예제 입력 2
BAAAAABAA
BAABAAAAAB
예제 출력 2
1
예제 입력 3
A
ABBA
예제 출력 3
0
 */
package algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
s에서부터 t를 찾으면 타임아웃 발생.
t에서부터 반대로 s를 찾아가보자
 */
public class AAndB2_2 {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();

        solution(t, s);

        System.out.println(result);
    }

    private static void solution(String t, String s) {
        if(result > 0) {
            return;
        }
        if(s.equals(t)) {
            result = 1;
        }
        if (!t.isEmpty()) {
            if(t.charAt(t.length()-1) == 'A') {
                solution(removeA(t), s);
            }
            if(t.charAt(0) == 'B') {
                solution(removeB(t), s);
            }
        }
    }

    public static String removeA(String s) {
        return s.substring(0, s.length() - 1);
    }

    public static String removeB(String s) {
        return new StringBuilder(s).reverse().delete(s.length()-1,s.length()).toString();
    }
}
