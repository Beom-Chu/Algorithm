package test.programers;


import org.junit.jupiter.api.*;
import algorithm.programers.DiskController;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
