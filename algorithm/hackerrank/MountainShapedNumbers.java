package algorithm.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/*

무작위로 주어진 숫자의 크기가 ㅅ 모양으로 이어지는 숫자들의 최대 개수 구하기
n번째와 n+1번째의 크기가 같아도 이어짐.

121232 => 1232
321 => 321
12134312 => 13431
3223122 => 2231

*/

public class MountainShapedNumbers {

  public int mountainShapedNumbers(List<Integer> list) {

    int idx = 0     /* 비교할 숫자의 시작점 */
      , tempIdx = 0 
      , max = 0     /* 최대 개수 */
      , size = list.size();
    
    while(idx < size-1) {
      
      boolean up = true;
      int tempMax = 1;
      
      for(int i=idx; i<size-1; i++) {
        
        /*상향*/
        if(up) {
          
          if(list.get(i) <= list.get(i+1)) {
            tempMax++; /*커지는 숫자 개수 ++*/
          } else {
            up = false; /* 방향전환 */
          }
        }
        
        /*하향*/
        if(!up) {
          
          if(list.get(i) >= list.get(i+1)) {
            tempMax++; /*작아지는 숫자 개수 ++*/
          } else {
            break;
          }
        }
        
        /* 다음 시작점 임시 설정 */
        if(list.get(i) != list.get(i+1)) {
          tempIdx = i+1;
        }
      }
      
      System.out.println("tempMax:"+tempMax+ "tempIdx:" + tempIdx);
      max = Math.max(max, tempMax);
      
      idx = tempIdx;
    }
    
    return max;
  }

  @Test
  void test() {
    
    List<Integer> list = new ArrayList<>(Arrays.asList(2,1,2,3,2,2,2,3,1,2)); /*6*/
//    List<Integer> list = new ArrayList<>(Arrays.asList(3,2,1)); /*3*/
//    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,1,2,2,1,2,1)); /*4*/
    
    
    System.out.println(mountainShapedNumbers(list));
    
  }
}
