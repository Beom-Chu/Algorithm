/*
비슷한 단어[2607]
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	16788	4379	3488	28.095%
문제
영문 알파벳 대문자로 이루어진 두 단어가 다음의 두 가지 조건을 만족하면 같은 구성을 갖는다고 말한다.

두 개의 단어가 같은 종류의 문자로 이루어져 있다.
같은 문자는 같은 개수 만큼 있다.
예를 들어 "DOG"와 "GOD"은 둘 다 'D', 'G', 'O' 세 종류의 문자로 이루어져 있으며
양쪽 모두 'D', 'G', 'O' 가 하나씩 있으므로 이 둘은 같은 구성을 갖는다.
하지만 "GOD"과 "GOOD"의 경우 "GOD"에는 'O'가 하나, "GOOD"에는 'O'가 두 개 있으므로 이 둘은 다른 구성을 갖는다.

두 단어가 같은 구성을 갖는 경우, 또는 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸어
나머지 한 단어와 같은 구성을 갖게 되는 경우에 이들 두 단어를 서로 비슷한 단어라고 한다.

예를 들어 "DOG"와 "GOD"은 같은 구성을 가지므로 이 둘은 비슷한 단어이다.
또한 "GOD"에서 'O'를 하나 추가하면 "GOOD" 과 같은 구성을 갖게 되므로 이 둘 또한 비슷한 단어이다.
하지만 "DOG"에서 하나의 문자를 더하거나, 빼거나, 바꾸어도 "DOLL"과 같은 구성이 되지는 않으므로 "DOG"과 "DOLL"은 비슷한 단어가 아니다.

입력으로 여러 개의 서로 다른 단어가 주어질 때, 첫 번째 단어와 비슷한 단어가 모두 몇 개인지 찾아 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 단어의 개수가 주어지고 둘째 줄부터는 한 줄에 하나씩 단어가 주어진다.
모든 단어는 영문 알파벳 대문자로 이루어져 있다. 단어의 개수는 100개 이하이며, 각 단어의 길이는 10 이하이다.

출력
입력으로 주어진 첫 번째 단어와 비슷한 단어가 몇 개인지 첫째 줄에 출력한다.

예제 입력 1
4
DOG
GOD
GOOD
DOLL
예제 출력 1
2
 */
package algorithm.baekjoon.string;

import java.io.*;

public class SimilarWords {
    // 1. 단어들을 사용된 알파벳의 갯수로 변환
    // 2. 알파벳별 갯수 비교시 1 이하로 차이가 나면 비슷한 단어로 판단.
    // 2-1. 길이가 같으면 2 이하로 차이나면 비슷한 단어로 판단.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordsCount = Integer.parseInt(reader.readLine());
        int[][] words = new int[wordsCount][27];
        for (int i = 0; i < wordsCount; i++) {
            for (char chr : reader.readLine().toCharArray()) {
                words[i][chr - 'A']++;
                // 마지막 배열 자리에는 전체 글자수
                words[i][26]++;
            }
        }

        int result = 0;
        for (int i = 1; i < wordsCount; i++) {
            int diff = 0;
            for (int j = 0; j < 26 && diff < 3; j++) {
                diff += Math.abs(words[0][j] - words[i][j]);
            }
            if (diff <= 1 || (diff == 2 && words[0][26] == words[i][26])) {
                result++;
            }
        }
        writer.write(String.valueOf(result));
        reader.close();
        writer.close();
    }
}
