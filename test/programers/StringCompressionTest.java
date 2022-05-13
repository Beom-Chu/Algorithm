package test.programers;

import algorithm.programers.StringCompression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {

    @Test
    public void test() {
        StringCompression stringCompression = new StringCompression();
        Assertions.assertEquals(7, stringCompression.solution("aabbaccc"));
        Assertions.assertEquals(9, stringCompression.solution("ababcdcdababcdcd"));
        Assertions.assertEquals(8, stringCompression.solution("abcabcdede"));
        Assertions.assertEquals(14, stringCompression.solution("abcabcabcabcdededededede"));
        Assertions.assertEquals(17, stringCompression.solution("xababcdcdababcdcd"));
        Assertions.assertEquals(6, stringCompression.solution("aaaaaaaaaaaabcd"));
        Assertions.assertEquals(5, stringCompression.solution("xxxxxxxxxxyyy"));
    }
}
