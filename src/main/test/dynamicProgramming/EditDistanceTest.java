package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
    private EditDistance editDistance = new EditDistance();

    @Test
    public void shouldReturnLengthOfTargetStringIfStartingStringIsEmpty() {
        assertEquals(3, editDistance.minOperations("", "abc"));
    }

    @Test
    public void shouldReturnLengthOfStartingStringIfTargetStringIsEmpty() {
        assertEquals(4, editDistance.minOperations("abcd", ""));
    }

    @Test
    public void shouldReturnOperationsIfOnlyInsertionOfLettersNeededAndLastLetterMatching() {
        assertEquals(2, editDistance.minOperations("ag", "abcg"));
    }

    @Test
    public void shouldReturnOperationsIfOnlyInsertionOfLettersNeededAndLastLetterNotMatching() {
        assertEquals(3, editDistance.minOperations("ai", "abcg"));
    }

    @Test
    public void shouldReturnOperationsIfStringsAreDifferentWithEqualLength() {
        assertEquals(3, editDistance.minOperations("abc", "xyz"));
    }

    @Test
    public void shouldReturnOperationsIfStartingStringIsSubstringOfTargetString() {
        assertEquals(5, editDistance.minOperations("abc", "xabcdefg"));
    }

    @Test
    public void shouldReturnOperationsIfTargetStringIsSubstringOfStartingString() {
        assertEquals(4, editDistance.minOperations("mnpqrst", "pqr"));
    }

    @Test
    public void shouldReturnZeroIfBothStringsAreSame() {
        assertEquals(0, editDistance.minOperations("abcd", "abcd"));
    }

    @Test
    public void shouerldReturnZeroIfBothStringsAreSame() {
        assertEquals(57, editDistance.minOperations("horsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorsehorse",
                "rosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosrosros"));
    }
}
