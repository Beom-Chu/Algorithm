/*
섬 연결하기

문제 설명
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 
최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 
예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

제한사항

섬의 개수 n은 1 이상 100 이하입니다.
costs의 길이는 ((n-1) * n) / 2이하입니다.
임의의 i에 대해, costs[i][0] 와 costs[i][1]에는 다리가 연결되는 두 섬의 번호가 들어있고, 
costs[i][2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 
즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 
이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
연결할 수 없는 섬은 주어지지 않습니다.

입출력 예

n   costs   return
4   [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]   4

입출력 예 설명
costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.

 0__(1)__1
 |     / |
(2) (5) (1)
 | /     |
 2__(8)__3



크루스칼 알고리즘 (Kruskal Algorithm) 사용

step 0) 모든 간선을 끊어 놓는다.
step 1) 가중치 순으로 간선들을 정렬한다. (오름차순)
step 2) 정렬된 간선을 순서대로 선택한다.
step 3) 선택한 간선의 두 정점이 연결되어 있지 않으면, 해당 간선을 최소 스패닝 트리에 포함 시키고 두 정점을 연결한다.

*/
package algorithm.programers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ConnectingTheIslands {

  static int[] parent;
  
  public int solution(int n, int[][] costs) {

    parent = new int[n];
    for(int i=0; i<parent.length; i++) {
      parent[i] = i;
    }
    
    //비용 크기 순으로 정렬
    Arrays.sort(costs, (i1, i2) -> i1[2] - i2[2]);
    
    int cost = 0;
    
    for(int i=0; i<costs.length; i++) {
      //아직 연결되지 않은 섬인 경우 연결 및 비용 추가
      if(!isConnect(costs[i][0], costs[i][1])) {
        union(costs[i][0], costs[i][1]);
        cost += costs[i][2];
      }
    }
    
    return cost;
  }

  public int find(int x) {
    if(x == parent[x]) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }
  
  public void union(int x, int y) {
    x = find(x);
    y = find(y);
    
    if(x != y) {
      parent[y] = x;
    }
  }
  
  public boolean isConnect(int x, int y) {
    x = find(x);
    y = find(y);

    return x == y;
  }

  
  
  
  
  @Test
  public void test1() {
    assertEquals(4, solution(4, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
  }
  @Test
  public void test2() {
    assertEquals(11, solution(6, new int[][] {{0, 1, 5}, {0, 3, 2}, {0, 4, 3}, {1, 4, 1}, {3, 4, 10}, {1, 2, 2}, {2, 5, 3}, {4, 5, 4}}));
  }
  @Test
  public void test3() {
    assertEquals(9, solution(4, new int[][] {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}}));
  }
  @Test
  public void test4() {
    assertEquals(7, solution(5, new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 3}, {2, 3, 8}, {3, 4, 1}}));
  }
  
}