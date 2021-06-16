package test.programers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithm.programers.DiskController;

class DiskControllerTest {

	@Test
	@DisplayName("디스크 컨트롤러")
	void testSolution() {
		DiskController diskController = new DiskController();
		
//		int[][] param = {{0, 3}, {1, 9}, {2, 6}};
		int[][] param = {{1, 9}, {0, 3},{1, 6}};
		
		int rtn = diskController.solution(param);
		
		assertEquals(9,rtn);
	}

}
