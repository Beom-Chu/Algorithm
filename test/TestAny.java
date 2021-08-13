package test;

import org.junit.jupiter.api.Test;

public class TestAny {

  @Test
  public void test() {
    String str = "abc|adf12";
    String[] strs = str.split("\\|");
    
    System.out.println("size : "+strs.length);
    
    for(String s : strs) {    
      System.out.println("s : "+s);
    }
  }

}
