/*
구명보트

문제 설명
무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 
구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만
1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 
모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.

입출력 예
people  limit   return
[70, 50, 80, 50]    100 3
[70, 80, 50]    100 3



*/
package algorithm.programers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Lifeboat {

  /* 효율성을 높이기 위해 컬렉션에 넣고 뺴는 작업을 제외하는 방법을 생각*/
  public int solution3(int[] people, int limit) {

    int answer = 0;
    int s = 0, b = people.length - 1;

    Arrays.sort(people);

    while (s < b) {

      if (people[s] + people[b] <= limit) {
        s++;
        b--;
      } else {
        b--;
      }

      answer++;
    }

    if (s == b) {
      answer++;
    }

    return answer;
  }
  
  
  /*
  중간에 종료될수 있는 조건을 추가 했으나 역시 효율성 실패
  */
  public int solution2(int[] people, int limit) {
    
    int answer = 0;
    Deque<Integer> peoples = new LinkedList<Integer>();
    peoples.addAll(Arrays.stream(people).boxed().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList()));

    while (!peoples.isEmpty()) {

      if (peoples.size() > 1) {

        // 앞사람 몸무게가 limit의 절반이하가 되면 이후 체중들은 모두 2명씩 탑승이 가능하므로
        // 남은 인원수 / 2 의 올림으로 더한 후 종료
        if (peoples.peekFirst() <= limit / 2) {
          answer += Math.ceil((double) peoples.size() / 2);
          break;
        }

        if (peoples.peekFirst() + peoples.peekLast() <= limit) {
          peoples.pollFirst();
          peoples.pollLast();
        } else {
          peoples.pollFirst();
        }

      } else {
        peoples.poll();
      }

      answer++;
    }

    return answer;
  }
  
  
  /*
   무거운 체중 순으로 정렬 후 
   맨앞 사람 + 맨뒷 사람의 체중이 Limit보다 작으면 두명을 보내고
   크면 앞사람만 보내면서 횟수를 더해줌
   채점결과 정확도는 통과했으나 효율성에서 통과 못함.
   */
  public int solution1(int[] people, int limit) {
    
    int answer = 0;
    Deque<Integer> peoples = new LinkedList<Integer>();
    peoples.addAll(Arrays.stream(people).boxed().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList()));

    while (!peoples.isEmpty()) {
      if (peoples.size() > 1) {

        if (peoples.peekFirst() + peoples.peekLast() <= limit) {
          peoples.pollFirst();
          peoples.pollLast();
        } else {
          peoples.pollFirst();
        }
      } else {
        peoples.poll();
      }
      answer++;
    }

    return answer;
  }
  
  
  @Test
  public void test1() {
    
    assertEquals(3, solution3(new int[] {70, 50, 80, 50},100));
  }
  
  @Test
  public void test2() {
    
    assertEquals(3, solution3(new int[] {70, 80, 50},100));
  }
  
  @Test
  public void test3() {
    
    assertEquals(9, solution3(new int[] {70, 50, 80, 50,70, 50, 80, 50,70, 50, 80, 50},100));
  }
}
