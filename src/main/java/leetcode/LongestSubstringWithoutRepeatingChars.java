package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> previousCharacters = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (previousCharacters.containsKey(c)) {
                if (previousCharacters.get(c) >= start) {
                    start = previousCharacters.get(c) + 1;
                }
            }

            maxLength = Math.max(maxLength, i - start + 1);
            previousCharacters.put(c, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
