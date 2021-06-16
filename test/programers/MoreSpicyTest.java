package test.programers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithm.programers.MoreSpicy;

class MoreSpicyTest {

	@Test
	@DisplayName("더 맵게")
	void testSolution() {
		MoreSpicy moreSpicy = new MoreSpicy();
		
//		입출력 예
//		scoville	K	return
//		[1, 2, 3, 9, 10, 12]	7	2
		
		int rtn = moreSpicy.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
		
		assertEquals(2 , rtn);
	}

}
