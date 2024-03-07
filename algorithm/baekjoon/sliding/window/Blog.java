/*
블로그[21921]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	10609	4416	3603	40.929%
문제
찬솔이는 블로그를 시작한 지 벌써 N일이 지났다.
요즘 바빠서 관리를 못 했다가 방문 기록을 봤더니 벌써 누적 방문 수가 6만을 넘었다.
찬솔이는 X일 동안 가장 많이 들어온 방문자 수와 그 기간들을 알고 싶다.
찬솔이를 대신해서 X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구해주자.

입력
첫째 줄에 블로그를 시작하고 지난 일수 N와 X가 공백으로 구분되어 주어진다.
둘째 줄에는 블로그 시작 1일차부터 N일차까지 하루 방문자 수가 공백으로 구분되어 주어진다.

출력
첫째 줄에 X일 동안 가장 많이 들어온 방문자 수를 출력한다.
만약 최대 방문자 수가 0명이라면 SAD를 출력한다.
만약 최대 방문자 수가 0명이 아닌 경우 둘째 줄에 기간이 몇 개 있는지 출력한다.

제한
1 <= X <= N <= 250,000
0 <= 방문자 수 <= 8,000

예제 입력 1
5 2
1 4 2 5 1
예제 출력 1
7
1
예제 입력 2
7 5
1 1 1 1 1 5 1
예제 출력 2
9
2
예제 입력 3
5 3
0 0 0 0 0
예제 출력 3
SAD
 */
package algorithm.baekjoon.sliding.window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog {
    // 슬라이딩 윈도우 사용
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stNX = new StringTokenizer(reader.readLine());
        StringTokenizer visitorsToken = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(stNX.nextToken());
        int X = Integer.parseInt(stNX.nextToken());
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(visitorsToken.nextToken());
        }


        int maximumNumber = 0;
        int sameCount = 1;
        int left = 0, right = X;

        // 초기값 설정
        for (int i = 0; i < X; i++) {
            maximumNumber += visitors[i];
        }
        int sum = maximumNumber;

        
        // 슬라이딩(최대값 발생하면 갱신, 동일하면 동일숫자++)
        while (right < N) {
            sum = ((sum - visitors[left]) + visitors[right]);
            if (maximumNumber == sum) {
                sameCount++;
            } else if (maximumNumber < sum) {
                maximumNumber = sum;
                sameCount = 1;
            }
            left++;
            right++;
        }


        if (maximumNumber == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maximumNumber);
            System.out.println(sameCount);
        }
    }
}
