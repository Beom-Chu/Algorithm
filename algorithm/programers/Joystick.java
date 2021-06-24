/*
조이스틱 
 
문제 설명
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name    return
"JEROEN"    56
"JAN"   23


좌우이동 횟수 구하기
1. A가 없는 경우는 전체 길이만큼 좌우 이동
2. A가 중간에 포함된 경우 우측으로 갔다가 좌측으로 이동해야 최소값 나올수 있음.

* 왼쪽 끝에서 왼쪽 이동을 하면 오른쪽 끝으로 이동되지만
* 오른쪽 끝에서 오른쪽으로는 이동되지 않음!!


ABAAABA

*/
package algorithm.programers;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Joystick {

  public int solution(String name) {
    
    int sum = 0;
    
    //커서접근여부
    List<Boolean> change = new ArrayList<>();
    
    //각 문자별로 최소 상하 이동수 구하기
    for(char chr : name.toCharArray()) {
      sum += getUpDownMoveCnt(chr);
      
      //A인 경우 커서가 갈 필요가 없으므로 true
      change.add(chr=='A');
    }
    
    //시작점은 이미 커서가 있으므로 true
    change.set(0, true);
    
    int temCnt = 0;
    int idx = 0;
    int nameLeng = name.length();
    
    //문자열의 모든 위치에 커서 접근이 완료될때까지 반복
    while(change.contains(false)) {
      
      int rightIdx = idx;
      int leftIdx = idx;
      
      while(true) {
        
        //기준위치 부터 좌,우로 index 늘려가며 가장 가까운 커서 접근 대상 위치를 찾는다.
        rightIdx = rightIdx+1 >= nameLeng ? 0 : rightIdx+1;
        leftIdx = leftIdx-1 < 0 ? nameLeng-1 : leftIdx-1;
        
        temCnt++;
        
        //오른쪽으로 가다가 왼쪽 끝으로 넘어갈 수 있으므로 오른쪽 우선.
        if(!change.get(rightIdx)) {
          change.set(rightIdx,true);
          idx = rightIdx;
          break;
        }
        
        if(!change.get(leftIdx)) {
          change.set(leftIdx,true);
          idx = leftIdx;
          break;
        }
      }
    }
    
    sum += temCnt;
    
    return sum;
  }
  
  //알파벳의 상하 이동 최소 이동수
  public int getUpDownMoveCnt(char chr) {
    
    int cnt = chr - 'A';
    
    if(cnt > 13) {
      cnt = 26 - cnt;
    }
    return cnt;
  }
  
  
  @Test
  public void test() {
    
    System.out.println(solution("JEROEN")); /*56*/
    System.out.println(solution("JAN"));    /*23*/
    System.out.println(solution("ABAAABA"));/*6*/
    System.out.println(solution("AAAA"));   /*0*/
    System.out.println(solution("AABAAB")); /*6*/
    System.out.println(solution("ABABAAAAAAABA"));/*11*/
    
  }
}
