package algorithm.programers;

/* 최대공약수, 최소공배수 */
public class GcdLcm {

  /* 최대공약수 */
  public long Gcd(int[] numbers) {
    int a = numbers[0], b = numbers[1], temp = 0;

    while (b > 0) {
      temp = b;
      b = a % b;
      a = temp;
    }

    return a;
  }

  /* 최대공약수 - 재귀 */
  public long GcdRecursion(int a, int b) {
    return b > 0 ? GcdRecursion(b, a % b) : a;
  }

  /* 최소공배수 */
  public long Lcm(int[] numbers) {
    return numbers[0] * numbers[1] / Gcd(numbers);
  }


  public static void main(String[] args) {

    int[] numbers = {12, 8};

    GcdLcm gcdLcm = new GcdLcm();
    long rtn = gcdLcm.Gcd(numbers);
    long rtn2 = gcdLcm.Lcm(numbers);
    long rtn3 = gcdLcm.GcdRecursion(numbers[0], numbers[1]);

    System.out.println("Gcd: " + rtn);
    System.out.println("Lcm: " + rtn2);
    System.out.println("gcd:" + rtn3);
  }

}
