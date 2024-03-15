/*
KCPC[3758] 다국어
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	3538	1701	1389	49.360%
문제
당신은 유명 프로그래밍 대회인 KCPC(Korean Collegiate Programming Contest)에 참가하고 있다.
이 대회에서 총 k개의 문제를 풀게 되는데, 어떤 문제에 대한 풀이를 서버에 제출하면 그 문제에 대해 0점에서 100점 사이의 점수를 얻는다.
풀이를 제출한 팀의 ID, 문제 번호, 점수가 서버의 로그에 제출되는 시간 순서대로 저장된다.
한 문제에 대한 풀이를 여러 번 제출할 수 있는데, 그 중 최고 점수가 그 문제에 대한 최종 점수가 된다.
(만약 어떤 문제에 대해 풀이를 한번도 제출하지 않았으면 그 문제에 대한 최종 점수는 0점이다.)

당신 팀의 최종 점수는 각 문제에 대해 받은 점수의 총합이고, 당신의 순위는 (당신 팀보다 높은 점수를 받은 팀의 수)+1 이다.

점수가 동일한 팀이 여럿 있을 수 있는데, 그 경우에는 다음 규칙에 의해서 순위가 정해진다.

1. 최종 점수가 같은 경우, 풀이를 제출한 횟수가 적은 팀의 순위가 높다.
2. 최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.

동시에 제출되는 풀이는 없고, 모든 팀이 적어도 한 번은 풀이를 제출한다고 가정하라.

서버의 로그가 주어졌을 때, 당신 팀의 순위를 계산하는 프로그램을 작성하시오.

입력
입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다.
입력의 첫 번째 줄에는 테스트 데이터의 수를 나타내는 정수 T가 주어진다.
각 테스트 데이터의 첫 번째 줄에는 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m을 나타내는 4 개의 정수가 주어진다.
여기서, 3 ≤ n, k ≤ 100, 1 ≤ t ≤ n, 3 ≤ m ≤ 10,000이다.
그 다음 m개의 줄에는 각 풀이에 대한 정보가 제출되는 순서대로 주어진다.
각 줄에는 팀 ID i, 문제 번호 j, 획득한 점수 s를 나타내는 세 개의 정수가 주어진다.
여기서 1 ≤ i ≤ n, 1 ≤ j ≤ k, 0 ≤ s ≤ 100이다.

출력
출력은 표준출력을 사용한다. 주어진 각 테스트 데이터에 대해 당신 팀의 순위를 한 줄에 출력하여야 한다

예제 입력 1
2
3 4 3 5
1 1 30
2 3 30
1 2 40
1 2 20
3 1 70
4 4 1 10
1 1 50
2 1 20
1 1 80
3 1 0
1 2 20
2 2 10
4 3 0
2 1 0
2 2 100
1 4 20
예제 출력 1
1
2
 */
package algorithm.baekjoon.sorting;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class KCPC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfTestCase = Integer.parseInt(reader.readLine());
        TestCase[] testCases = new TestCase[numberOfTestCase];
        for (int i = 0; i < numberOfTestCase; i++) {
            testCases[i] = new TestCase(reader.readLine());
            for (int j = 0; j < testCases[i].m; j++) {
                testCases[i].logs[j] = new Log(reader.readLine());
            }
        }

        for (TestCase testCase : testCases) {
            Map<Integer, Team> teams = new HashMap<>();
            int lastSubmission = 0;
            for (Log log : testCase.logs) {
                if (!teams.containsKey(log.teamId)) {
                    teams.put(log.teamId, new Team());
                }
                teams.get(log.teamId).setLog(log, lastSubmission);
                lastSubmission++;
            }

            List<Integer> collect = teams.entrySet().stream()
                    .sorted(new TeamComparator())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            int index = collect.indexOf(testCase.t);
            writer.write((index + 1) + "\n");
        }

        writer.flush();

        reader.close();
        writer.close();
    }

    static class TeamComparator implements Comparator<Map.Entry<Integer, Team>> {
        @Override
        public int compare(Map.Entry<Integer, Team> o1, Map.Entry<Integer, Team> o2) {
            if (o2.getValue().getTotalScore().compareTo(o1.getValue().getTotalScore()) == 0) {
                if (o1.getValue().numberOfSubmissions == o2.getValue().numberOfSubmissions) {
                    return o1.getValue().lastSubmission - o2.getValue().lastSubmission;
                } else {
                    return o1.getValue().numberOfSubmissions - o2.getValue().numberOfSubmissions;
                }
            } else {
                return o2.getValue().getTotalScore().compareTo(o1.getValue().getTotalScore());
            }
        }
    }

    static class TestCase {
        int n, k, t, m;
        Log[] logs;

        public TestCase(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.n = Integer.parseInt(st.nextToken());
            this.k = Integer.parseInt(st.nextToken());
            this.t = Integer.parseInt(st.nextToken());
            this.m = Integer.parseInt(st.nextToken());
            this.logs = new Log[this.m];
        }
    }

    static class Log {
        int teamId;
        int questionNumber;
        int score;

        public Log(String s) {
            StringTokenizer st = new StringTokenizer(s);
            this.teamId = Integer.parseInt(st.nextToken());
            this.questionNumber = Integer.parseInt(st.nextToken());
            this.score = Integer.parseInt(st.nextToken());
        }
    }

    static class Team {
        Map<Integer, Integer> questionScores = new HashMap<>();
        int numberOfSubmissions = 0;
        int lastSubmission = 0;

        public void setLog(Log log, int lastSubmission) {
            if (questionScores.containsKey(log.questionNumber)) {
                if (questionScores.get(log.questionNumber) < log.score) {
                    questionScores.put(log.questionNumber, log.score);
                }
            } else {
                questionScores.put(log.questionNumber, log.score);
            }
            this.numberOfSubmissions++;
            this.lastSubmission = lastSubmission;
        }

        public Integer getTotalScore() {
            return questionScores.values().stream().mapToInt(integer -> integer).sum();
        }
    }
}
