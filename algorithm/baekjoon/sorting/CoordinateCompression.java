/*
좌표 압축 [18870]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	45753	19319	14767	40.171%
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
예제 입력 1
5
2 4 -10 4 -9
예제 출력 1
2 3 0 3 1
예제 입력 2
6
1000 999 1000 999 1000 999
예제 출력 2
1 0 1 0 1 0
 */
package algorithm.baekjoon.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class CoordinateCompression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] X = new int[N];

        for (int i = 0; i < N; i++) {
            X[i] = scanner.nextInt();
        }

        //중복 제거 후 순위 구하기
        int[] rank = Arrays.stream(X).distinct().sorted().toArray();

        // 숫자별 랭킹 설정
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rank.length; i++) {
            map.put(rank[i], i);
        }

        //출력
        StringJoiner sj = new StringJoiner(" ");
        for(int x : X) {
            sj.add(String.valueOf(map.get(x)));
        }
        System.out.println(sj);
    }
}
