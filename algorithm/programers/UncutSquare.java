/*
멀쩡한 사각형
문제 설명
가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다.
종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다.
이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다.
그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다.
새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

제한사항
W, H : 1억 이하의 자연수
입출력 예
W	H	result
8	12	80
입출력 예 설명
입출력 예 #1
가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다. 원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.

풀이
잘리는 가로/세로가 최대 공약수만큼 반복 됨.
가로/세로 비율로 잘리는 갯수는 n + m - 1
 */
package algorithm.programers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class UncutSquare {

    public long solution(long w, long h) {
        long gcd = gcd(w, h);
//        return (w * h) - (((w / gcd) + (h / gcd) - 1) * gcd);
        return (w * h) - (w + h - gcd);
    }

    /* 최대 공약수 */
    public long gcd(long n, long m) {
        return m < 1 ? n : gcd(m, n % m);
    }

    /* BigInteger 최대 공약수 함수 사용 */
    public long solution2(int w, int h) {
        long totalCount = (long) w * (long) h;
        long diagonalCount = w + h - BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();

        return totalCount - diagonalCount;
    }

    @Test
    public void test() {

        Assertions.assertEquals(80, solution(8, 12));
        Assertions.assertEquals(20, solution(5, 5));
        Assertions.assertEquals(0, solution(1, 10));
    }
}
/*
1.41

2:2 2 1:1
2:3 4
2:4 4
2:5 6
2:6 6 1:3
2:7 8
2:8 8 1:4

3:3 3 1:1
3:4 6
3:5 7
3:6 6 1:2
3:7 9
3:8 10

4:4 4
4:5 8
4:6 8
4:7 10
4:8 8

12 8
8 4
4 1

 */