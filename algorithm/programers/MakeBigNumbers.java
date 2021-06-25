/*
큰 수 만들기

문제 설명
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.

제한 조건
number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
k는 1 이상 number의 자릿수 미만인 자연수입니다.

입출력 예
number  k   return
"1924"  2   "94"
"1231234"   3   "3234"
"4177252841"    4   "775841"

*/
package algorithm.programers;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class MakeBigNumbers {
  
  /* 
   * fr, to 범위 내에서 가장 큰 숫자를 반속해서 가져오는데
   * fr의 시작 index는 0,
   * to의 시작 index는 전체 길이에서 k를 모두 삭제했을때의 길이를 뺀 숫자
   * 범위내에서 큰 숫자를 가져오면 
   * fr은 큰숫자의 index+1
   * to는 이전 to+1
   * 반복해서 처리
   * */
  public String solution(String number, int k) {

    StringBuilder answer = new StringBuilder();
    StringBuilder numbers = new StringBuilder();
    numbers.append(number.toCharArray());

    int size = number.length();
    int fr = 0;
    int to = size - (size - k);

    while (to < size) {

      int bigIdx = getBigIndex(numbers, fr, to);

      answer.append(numbers.charAt(bigIdx));

      fr = bigIdx + 1;
      to++;
    }

    return answer.toString();
  }
  
  //범위 중 가장 큰 숫자의 Index 반환
  public int getBigIndex(StringBuilder sb, int fr, int to) {

    int maxIdx = fr;
    int max = sb.charAt(fr) - '0';

    for (int i = fr; i <= to; i++) {
      int num = sb.charAt(i) - '0';
      if (num > max) {
        max = num;
        maxIdx = i;
      }
    }

    return maxIdx;
  }
  
  
  
  
  /* Stack을 활용한 심플한 코드 */
  public String solution_simple(String number, int k) {
    char[] result = new char[number.length() - k];
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      System.out.println(stack+","+c);
      while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
        stack.pop();
      }
      stack.push(c);
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = stack.get(i);
    }
    return new String(result);
}
  
  
  
  
  /* 맨 앞에서부터 K+1만큼의 범위에서 가장 작은 숫자를 제거
   * 범위를 줄여가며 반복.. 했으나 실패
   * */
  public String solution_fail(String number, int k) {

    StringBuilder answer = new StringBuilder();
    answer.append(number.toCharArray());

    int orgSize = number.length();
    int curSize = answer.length();
    
    while (curSize > orgSize - k ) {
      
      int delIdx = getMinIndex(answer, curSize - k + 1);
      answer.deleteCharAt(delIdx);
      
      curSize = answer.length();
    }
    
    return answer.toString();
  }
  
  // 범위 중 가장 작은 숫자의 Index 반환
  public int getMinIndex(StringBuilder sb, int range) {
    
    int minIdx = range;
    int min = sb.charAt(range);
    
    for(int i=0; i<range; i++) {
      if(sb.charAt(i) < min) {
        min = sb.charAt(i);
        minIdx = i;
      }
    }
    
    return minIdx;
  }
  
  @Test
  public void test() {
    
    
//    System.out.println(solution("1924",2)); /*94*/
    
//    System.out.println(solution("1231234",3)); /*3234*/
    
    System.out.println(solution_simple("4177252841",4)); /*775841*/
    
    
  }
}
