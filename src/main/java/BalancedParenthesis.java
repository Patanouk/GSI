import java.util.Stack;

public class BalancedParenthesis {

    /*
    https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
     */
    public static boolean isBalanced(String expression) {
        Stack<Character> bracketStack = new Stack<>();
        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    bracketStack.push(c);
                    break;

                case ')':
                    if (bracketStack.isEmpty() || bracketStack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (bracketStack.isEmpty() || bracketStack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (bracketStack.isEmpty() || bracketStack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }

        return bracketStack.isEmpty();
    }
}
