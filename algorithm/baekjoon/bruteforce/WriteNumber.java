/*
수 이어 쓰기[1515]
시간 제한	메모리 제한	제출	    정답	    맞힌 사람	정답 비율
2 초	128 MB	    2961	1361	1134	48.235%
문제
세준이는 1부터 N까지 모든 수를 차례대로 공백없이 한 줄에 다 썼다.
그리고 나서, 세준이가 저녁을 먹으러 나간 사이에 다솜이는 세준이가 쓴 수에서 마음에 드는 몇 개의 숫자를 지웠다.
세준이는 저녁을 먹으러 갔다 와서, 자기가 쓴 수의 일부가 지워져있는 모습을 보고 충격받았다.
세준이는 수를 방금 전과 똑같이 쓰려고 한다. 하지만, N이 기억이 나지 않는다.
남은 수를 이어 붙인 수가 주어질 때, N의 최솟값을 구하는 프로그램을 작성하시오. 아무것도 지우지 않을 수도 있다.)

입력
첫째 줄에 지우고 남은 수를 한 줄로 이어 붙인 수가 주어진다. 이 수는 최대 3,000자리다.

출력
가능한 N 중에 최솟값을 출력한다.

예제 입력 1
1234
예제 출력 1
4
예제 입력 2
234092
예제 출력 2
20
예제 입력 3
999909
예제 출력 3
49
예제 입력 4
82340329923
예제 출력 4
43
예제 입력 5
32098221
예제 출력 5
61
예제 입력 6
1111111
예제 출력 6
14
예제 입력 7
00000000000000000000000000000000000000000000000000000000000000000000000
예제 출력 7
400
예제 입력 8
345029834023049820394802334909240982039842039483294792934790209
예제 출력 8
279
 */
package algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteNumber {
    // 임의의 숫자를 1에서부터 증가시키며 적혀있는 숫자가 포함되는지 체크
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = reader.readLine();
        int index = 0, number = 0;

        while(number <= 30000) {
            String stringNumber = String.valueOf(++number);
            for (int i = 0; i < stringNumber.length(); i++) {
                if(stringNumber.charAt(i) == numbers.charAt(index)) {
                    index++;
                }
                if(numbers.length() <= index) {
                    System.out.println(stringNumber);
                    return;
                }
            }
        }
    }
}
