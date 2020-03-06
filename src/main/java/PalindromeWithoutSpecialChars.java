import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given a string that can contain special characters,
 the task was to find if string formed using characters (ignoring special ones) is a palindrome
 */
public class PalindromeWithoutSpecialChars {
    private static final Set<Character> specialCharacters = new HashSet<>(Arrays.asList('!', '$'));

    //Avoid null as input...
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            while (i < input.length() && specialCharacters.contains(input.charAt(i))) {
                i++;
            }
            while (j >= 0 && specialCharacters.contains(input.charAt(j))) {
                j--;
            }

            if (i == input.length() || j == 0) {
                return true;
            }

            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
