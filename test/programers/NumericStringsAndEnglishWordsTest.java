package test.programers;

import algorithm.programers.NumericStringsAndEnglishWords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumericStringsAndEnglishWordsTest {

    @Test
    public void test(){
        NumericStringsAndEnglishWords numericStringsAndEnglishWords = new NumericStringsAndEnglishWords();

        Assertions.assertEquals(1478, numericStringsAndEnglishWords.solution("one4seveneight"));
        Assertions.assertEquals(234567, numericStringsAndEnglishWords.solution("23four5six7"));
        Assertions.assertEquals(234567, numericStringsAndEnglishWords.solution("2three45sixseven"));
        Assertions.assertEquals(123, numericStringsAndEnglishWords.solution("123"));
    }
}
