package algorithm.baekjoon.implementation;
/*
삼각형과 세 변 다국어[5073]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	27897	13305	12252	48.671%
문제
삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.

Equilateral :  세 변의 길이가 모두 같은 경우
Isosceles : 두 변의 길이만 같은 경우
Scalene : 세 변의 길이가 모두 다른 경우
단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다.
가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.

세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.

입력
각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.

출력
각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.

예제 입력 1
7 7 7
6 5 4
3 2 5
6 2 6
0 0 0
예제 출력 1
Equilateral
Scalene
Invalid
Isosceles
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriangleAndThreeSides {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[3];

        while(true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            if(numbers[0] + numbers[1] + numbers[2] == 0) {
                break;
            }

            if(isInvalid(numbers)) {
                System.out.println("Invalid");
            } else if(isEquilateral(numbers)) {
                System.out.println("Equilateral");
            } else if(isIsosceles(numbers)) {
                System.out.println("Isosceles");
            } else if(isScalene(numbers)) {
                System.out.println("Scalene");
            }
        }
    }

    private static boolean isScalene(int[] numbers) {
        return numbers[0] != numbers[1] && numbers[1] != numbers[2];
    }

    private static boolean isIsosceles(int[] numbers) {
        return numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[0];
    }

    private static boolean isEquilateral(int[] numbers) {
        return numbers[0] == numbers[1] && numbers[1] == numbers[2];
    }

    private static boolean isInvalid(int[] n) {
        return n[0] + n[1] <= n[2] || n[1] + n[2] <= n[0] || n[0] + n[2] <= n[1];
    }
}
