package algorithm.baekjoon.math;
/*
ZOAC 4[23971]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	512 MB	5344	2590	2344	50.474%
문제
2021년 12월, 네 번째로 개최된 ZOAC의 오프닝을 맡은 성우는 오프라인 대회를 대비하여 강의실을 예약하려고 한다.
강의실에서 대회를 치르려면 거리두기 수칙을 지켜야 한다!
한 명씩 앉을 수 있는 테이블이 행마다 W개씩 H행에 걸쳐 있을 때, 모든 참가자는 세로로 N칸 또는 가로로 M칸 이상 비우고 앉아야 한다.
즉, 다른 모든 참가자와 세로줄 번호의 차가 N보다 크거나 가로줄 번호의 차가 M보다 큰 곳에만 앉을 수 있다.
논문과 과제에 시달리는 성우를 위해 강의실이 거리두기 수칙을 지키면서 최대 몇 명을 수용할 수 있는지 구해보자.

입력
H, W, N, M이 공백으로 구분되어 주어진다. (0 < H, W, N, M ≤ 50,000)

출력
강의실이 수용할 수 있는 최대 인원 수를 출력한다.

예제 입력 1
5 4 1 1
예제 출력 1
6
i행 j열 자리를 (i, j)라고 할 때, (1,1)에 참가자가 앉은 경우 다른 참가자는 (1,2), (2,1), (2,2) 자리를 제외한 나머지 자리에 앉을 수 있다.

(2,2)의 경우는 (1,1)과 행 번호 및 열 번호의 차가 1보다 크지 않으므로 앉을 수 없다.
*/
import java.util.Scanner;

public class Zoac4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double H = Double.parseDouble(scanner.next());
        double W = Double.parseDouble(scanner.next());
        double N = Double.parseDouble(scanner.next());
        double M = Double.parseDouble(scanner.next());

        System.out.println((int) (Math.ceil(H / (N+1)) * Math.ceil(W / (M+1))));

        scanner.close();
    }
}
