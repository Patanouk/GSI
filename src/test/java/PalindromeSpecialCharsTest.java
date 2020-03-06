import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeSpecialCharsTest {

    @Test
    public void testIsPalindromeWithoutSpecialChars() {
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome(null));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("ab"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("a$b"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("ab$bb"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("abbb!"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("!abbb"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("!ab$bb"));
        assertFalse(PalindromeWithoutSpecialChars.isPalindrome("!ab$!bb"));

        assertTrue(PalindromeWithoutSpecialChars.isPalindrome(""));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("!$"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("a"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("a!"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("!a"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("!a$"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("!aa$"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("!a$a"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("a!$a"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("a!aa$a"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("abba"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("abcba!"));
        assertTrue(PalindromeWithoutSpecialChars.isPalindrome("a$b!ba"));
    }
}