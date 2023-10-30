/**
 * 별 찍기 - 7 [2444]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	67632	40446	36158	60.636%
문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.

예제 입력 1
5
예제 출력 1
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
 */
package algorithm.baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PickTheStars_7 {
    public static void main(String[] args) throws IOException {

    /*
    1. N번째 줄 아래는 이전 문자열 재활용
    2. N번째 줄까지의 규칙
      2-1. 공백은 N-1에서 하나씩 줄어듬
      2-2. "*"은 1에서 2씩 증가
    */

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> stars = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String star = " ".repeat(n - i)
                        + "*".repeat((i * 2) - 1);
            stars.add(star);
            System.out.println(star);
        }

        for (int i = n - 2; i >= 0; i--) {
            System.out.println(stars.get(i));
        }
    }


}
