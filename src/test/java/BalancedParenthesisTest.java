import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BalancedParenthesisTest {

    @Test
    public void testBalancedParenthesis() {
        assertTrue(BalancedParenthesis.isBalanced(""));
        assertTrue(BalancedParenthesis.isBalanced("()"));
        assertTrue(BalancedParenthesis.isBalanced("({})"));
        assertTrue(BalancedParenthesis.isBalanced("([()](){[]})"));

        assertFalse(BalancedParenthesis.isBalanced("["));
        assertFalse(BalancedParenthesis.isBalanced("]]]"));
        assertFalse(BalancedParenthesis.isBalanced("{]"));
        assertFalse(BalancedParenthesis.isBalanced("[([})]"));
    }
}