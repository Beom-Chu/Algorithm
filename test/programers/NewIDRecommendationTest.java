/*
예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"	"abcdefghijklmn"
*/

package test.programers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithm.programers.NewIDRecommendation;

class NewIDRecommendationTest {

	@Test
	@DisplayName("신규 아이디 추천")
	void testSolution() {
		
		NewIDRecommendation newIDRecommendation = new NewIDRecommendation();
		
		
		assertAll(
				()->assertEquals("bat.y.abcdefghi", newIDRecommendation.solution("...!@BaT#*..y.abcdefghijklm")),
				()->assertEquals("z--", newIDRecommendation.solution("z-+.^.")),
				()->assertEquals("aaa", newIDRecommendation.solution("=.=")),
				()->assertEquals("123_.def", newIDRecommendation.solution("123_.def")),
				()->assertEquals("abcdefghijklmn", newIDRecommendation.solution("abcdefghijklmn.p"))
		);
		
	}

}
