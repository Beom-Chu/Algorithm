/*깊이우선탐색 [Depth-first search]
 출발노드에서 목표노드까지의 최단 길이 경로를 보장한다.
 
  0
 /
1---3   7
|  /|\ /
| / | 5
|/  |  \
2---4   6--8

 */
package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithm.Dfs;

class DfsTest {
	
	Dfs dfs;
	
	@BeforeEach
	void setNode() {
		dfs = new Dfs(9);
		dfs.connectNode(0, 1);
		dfs.connectNode(1, 2);
		dfs.connectNode(1, 3);
		dfs.connectNode(2, 4);
		dfs.connectNode(2, 3);
		dfs.connectNode(3, 4);
		dfs.connectNode(3, 5);
		dfs.connectNode(5, 7);
		dfs.connectNode(5, 6);
		dfs.connectNode(6, 8);
	}
	
	@Test
	@DisplayName("깊이우선탐색_Stack")
	void testDfs() {
		
		dfs.dfs();
	}

	@Test
	@DisplayName("깊이우선탐색_재귀")
	void testDfs2() {
		
		dfs.recursive();
	}

}
