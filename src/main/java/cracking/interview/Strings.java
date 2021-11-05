package cracking.interview;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Strings {

    public static void main(String[] args) {
        System.out.println(areLessThanOneEditAway("ad", "abc"));
    }

// ---------------------------------------------------------------------------------------------------------------------
//  1.1 Implement an algorithm to determine if a string has all unique characters. What if you
    //cannot use additional data structures?

    //This is O(n)
    public static boolean hasUniqueChars(String s) {
        Set<Character> seenChars = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (seenChars.contains(c)) {
                return false;
            }
            seenChars.add(c);
        }
        return true;
    }

    //Assuming the possible characters of the string are in the ascii range (0 - 255)
    public static boolean hasUniqueCharsNoAdditionalsDataStructure(String s) {
        BitSet bitSet = new BitSet(26);

        for (char c : s.toCharArray()) {
            int bit = c - 'a';

            if (bitSet.get(bit)) {
                return false;
            }
            bitSet.set(bit);
        }
        return true;
    }

// ---------------------------------------------------------------------------------------------------------------------
//  1.3 URLify
    public static String replaceWhitespaces(String input) {
        return input.replace(" ", "%20");
    }


// ---------------------------------------------------------------------------------------------------------------------
//  1.4 Palindrome Permutation
    public static boolean isPalindromePermutation(String input) {
        Set<Character> characters = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!characters.contains(c)) {
                characters.add(c);
            } else {
                characters.remove(c);
            }
        }

        return characters.size() <= 1;
    }

// ---------------------------------------------------------------------------------------------------------------------
//  1.5 One Away

    public static boolean areLessThanOneEditAway(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }

        if (s1.length() == s2.length()) {
            return areOneReplaceAway(s1, s2);
        } else if (s1.length() > s2.length()) {
            return areOneInsertAway(s1, s2);
        } else {
            return areOneInsertAway(s2, s1);
        }
    }

    //Insert and Replace are basically the same
    //Can we insert one char in s2 to make it equal to s1
    private static boolean areOneInsertAway(String s1, String s2) {
        if (s2.length() >= s1.length()) {
            return false;
        }

        int index1 = 0;
        int index2 = 0;
        int numInsert = 0;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                index1++;
                numInsert++;
                if (numInsert > 1) {
                    return false;
                }

            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    //This assume both string have the same length
    private static boolean areOneReplaceAway(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int numDifferences = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }

            numDifferences++;
            if (numDifferences > 1) {
                return false;
            }
        }
        return true;
    }
}
