/* 가장 먼 노드
 * 문제 설명
n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
입출력 예
n	vertex	return
6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
입출력 예 설명
예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.

1--2--5
ㅣ/ ㅣ
3--4
ㅣ
6
 */
package algorithm.programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
	
	public Node[] nodes;
	
    public int solution(int n, int[][] edge) {
    	
        int answer = 0;
        nodes = new Node[n];
        Queue<Node> que = new LinkedList<>();
		
        /* 노드객체 생성 */
		for(int i=0; i<n; i++) {
			nodes[i] = new Node(i+1);
		}
		
		/* 노드 연결 */
		for(int i=0; i<edge.length; i++) {
			connectNode(edge[i][0], edge[i][1]);
		}
		
		/* 너비우선탐색 사용 */
		nodes[0].chk = true;
		que.add(nodes[0]);
		
		while(!que.isEmpty()) {
			
			Node root = que.poll();
			
			for(Node cnnNode : root.cnnNodes) {
				if(!cnnNode.chk) {
					cnnNode.chk = true;
					cnnNode.bfNodes.addAll(root.bfNodes); /* 지나온 노드 등록 */
					que.add(cnnNode);
				}
			}
		}
		
		/* 최장거리 */
		int maxDistance = Arrays.stream(nodes).mapToInt(i ->i.bfNodes.size()).max().getAsInt();
				
		for(Node node : nodes) {
			if(maxDistance == node.bfNodes.size()) answer++;
		}
		
        return answer;
    }
	
    /* 노드 */
    class Node{
    	
    	int no;
    	boolean chk;
    	LinkedList<Node> cnnNodes = new LinkedList<>();;
    	HashSet<Integer> bfNodes = new HashSet<>();

    	Node(int no){
    		this.no = no;
    		chk = false;
    		bfNodes.add(no);
    	}
    	
    	@Override
    	public String toString() {
    		return String.format("no:%s, chk:%s, cnnNode.size:%s, bfNodes:%s", no, chk, cnnNodes.size(),bfNodes);
    	}
    }
    
    /* 노드 연결 */
    void connectNode(int n1, int n2){
    	Node node1 = nodes[n1-1];
    	Node node2 = nodes[n2-1];
    	if(!node1.cnnNodes.contains(node2)) node1.cnnNodes.add(node2);
    	if(!node2.cnnNodes.contains(node1)) node2.cnnNodes.add(node1);
    }
    
    
}
