package cracking.interview;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Strings {

    public static void main(String[] args) {
        System.out.println(hasUniqueCharsNoAdditionalsDataStructure("abz"));
    }

    //1.1 Implement an algorithm to determine if a string has all unique characters. What if you
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
}
