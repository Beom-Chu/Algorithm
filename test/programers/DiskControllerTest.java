package test.programers;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import algorithm.programers.DiskController;

class DiskControllerTest {

  static DiskController diskController;
  static int[][] param;
  static int expected;
  static long st;
  
  @BeforeAll
  static void befroeAll() {
    param = new int[][]{{0, 3}, {1, 9}, {2, 6}};
    expected = 9;
    diskController = new DiskController();
  }
  
  @BeforeEach
  void beforeEach(){
    st = System.currentTimeMillis();
  }
  
  @AfterEach
  void afterEach() {
    System.out.println(System.currentTimeMillis()-st);
  }
  
  @Test
  @DisplayName("solution")
  void testSolution() {

    int rtn = diskController.solution(param);
    
    assertEquals(expected, rtn);
  }
  
  @Test
  @DisplayName("solution2")
  void testSolution2() {

    int rtn = diskController.solution2(param);

    assertEquals(expected, rtn);
  }

}
