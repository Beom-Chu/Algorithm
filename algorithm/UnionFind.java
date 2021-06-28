/*
유니온 파인드(Union-Find)

* 대표적 그래프 알고리즘으로 '합집합 찾기'라는 의미를 가지고 있습니다.
* 상호 배타적 집합(Disjoint-set)이라고도 합니다.
* 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘이다.

## 2가지 연산으로 이루어져 있습니다.
 * Find : x가 어떤 집합에 포함되어 있는지 찾는 연산
 * Union : x와 y가 포함되어 있는 집합을 합치는 연산
    
*/
package algorithm;

import org.junit.jupiter.api.Test;

public class UnionFind {

  static int[] parent;
  
  public void unionFind() {

    parent = new int[10];

    for(int i=0; i<parent.length; i++) {
      parent[i] = i;
    }
    
    for(int i : parent) {
      System.out.print(i+" ");
    }
    System.out.println();
    
    union(1,2);
    union(2,3);
    union(3,5);
    union(7,8);
    
    for(int i : parent) {
      System.out.print(i+" ");
    }
    System.out.println();
    
    System.out.println(isSameParent(1, 5));
    System.out.println(isSameParent(1, 7));
    System.out.println(isSameParent(8, 7));
  }

  //부모 노드 찾기
  public int find(int x) {
    if (parent[x] == x) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }
  
  //부모 노드 합치기
  public void union(int x, int y) {
    x = find(x);
    y = find(y);
    
    if (x != y) {
      parent[y] = x;
    }
  }
  
  //같은 부모 노드 여부 확인
  public boolean isSameParent(int x, int y) {
    x = parent[x];
    y = parent[y];
    
    return x == y;
  }
  
  
  
  @Test
  public void test() {
    unionFind();
  }
}
