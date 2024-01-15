package test.etc;

import org.junit.jupiter.api.Test;

public class EtcTest {
    @Test
    public void test() {

        int i1 = Integer.parseInt("1000000", 2);
        System.out.println("[[[i1 = " + i1);

        int i2 = Integer.parseInt("1000", 2);
        System.out.println("[[[i2 = " + i2);

        System.out.println("[[[" + (32 >> 1));
    }
}
