/* Luck Balance
 * 
 컨테스트 참여하여 떨어질 경우는 운이 상승하고, 이길 경우는 운이 감소한다.
 중요한 컨테스트는 k번 이하로 질 수 있다.
 이 때 가장 큰 운의 값을 구하는 문제이다. 
 
Sample Input
STDIN       Function
-----       --------
6 3         n = 6, k = 3
5 1         contests = [[5, 1], [2, 1], [1, 1], [8, 1], [10, 0], [5, 0]]
2 1
1 1
8 1
10 0
5 0

ample Output
29

n은 컨테스트 참여 횟수
k는 질수있는 컨테스트 수
list 0은 질 경우 상승하는 운
list 1은 컨테스트 중요도 [0:비중요, 1:중요]


해결방법
리스트를 운의 높은 순으로 정렬 후
 중요도가 낮으면 무조건 더하기
 중요도가 높은 경우는 k를 감소시키며 더해주고
 				k가 0이 되면 빼줌.
 */
package algorithm.hackerrank;

import java.util.List;

public class LuckBalance {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {
        
        int rtn = 0;
        
        contests.sort((o1,o2)->o2.get(0).compareTo(o1.get(0)));
        
        for(List<Integer> li : contests){
        	
            if(li.get(1) == 0) rtn += li.get(0);
            else {
                if(k>0) {
                    rtn += li.get(0);
                    k--;
                }else{
                    rtn -= li.get(0);
                }
            }
        }
        
        return rtn;
    }

}
