package test.hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import algorithm.hackerrank.RepeatedString;

class RepeatedStringTest {

  @Test
  void testRepeatedString() {
    RepeatedString repeatedString = new RepeatedString();
    
    assertEquals(7,repeatedString.repeatedString("aba", 10));
    
  }
  
  @Test
  void testRepeatedString2() {
    RepeatedString repeatedString = new RepeatedString();
    
    assertEquals(1_000_000_000,repeatedString.repeatedString("a", 1_000_000_000));
    
  }
}
