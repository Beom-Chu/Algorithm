package test.programers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import algorithm.programers.DoublePriorityQueue;

class DoublePriorityQueueTest {

  static DoublePriorityQueue dpq;
  static String[] operations;
  static int[] expected;
  
  @BeforeAll
  static void beforeAll() {
    dpq = new DoublePriorityQueue();
    operations = new String[]{"I 7","I 5","I -5","D -1"};
    expected = new int[] {7,5};
  }
  
  @Test
  @DisplayName("Solution1")
  void testSolution1() {
    int[] rtn = dpq.solution1(operations);
    assertArrayEquals(expected, rtn);
  }

  @Test
  @DisplayName("Solution2")
  void testSolution2() {
    int[] rtn = dpq.solution2(operations);
    assertArrayEquals(expected, rtn);
  }

}
