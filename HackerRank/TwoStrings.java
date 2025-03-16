/*
 * 
 * Given two strings, determine if they share a common substring (at least one
 * common character).
 * If they do, return "YES", otherwise return "NO".
 * Example:
 * Input
 * hello
 * world
 * Output
 * YES
 * Explanation: Both "hello" and "world" share the character 'o', so the answer
 * is "YES".
 * 
 */
package HackerRank;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
    public static void main(String args[]) {
        // Create an instance of the class
        TwoStrings obj = new TwoStrings();

        // Sample test cases
        String s1 = "hello";
        String s2 = "world";
        System.out.println("Using Method 1: " + obj.twoStrings(s1, s2)); // Output: YES
        System.out.println("Using Method 2: " + obj.twoStringsMethodTwo(s1, s2)); // Output: YES

        s1 = "abc";
        s2 = "def";
        System.out.println("Using Method 1: " + obj.twoStrings(s1, s2)); // Output: NO
        System.out.println("Using Method 2: " + obj.twoStringsMethodTwo(s1, s2)); // Output: NO
    }

    public String twoStrings(String s1, String s2) {

        Set<Character> s1Set = new HashSet<>();
        Set<Character> s2Set = new HashSet<>();

        // creating the set of string1
        for (char c : s1.toCharArray()) {
            s1Set.add(c);
        }
        // creating the set of string2
        for (char c : s2.toCharArray()) {
            s2Set.add(c);
        }

        // store the set intersection in s1Set
        s1Set.retainAll(s2Set);

        if (!s1Set.isEmpty())
            return "YES";

        return "NO";
    }

    public String twoStringsMethodTwo(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        // Create a frequency array of size 26
        char[] freq = new char[26];

        // Increase the frequency of each character for string s2
        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a']++;
        }

        // Check each character in string s1 for frequency.
        // If the frequency is greater than 0, it means you found a substring. Simply
        // return YES
        for (int i = 0; i < s1.length(); i++) {
            if (freq[s1.charAt(i) - 'a'] > 0) {
                return "YES";
            }
        }

        return "NO";
    }
}

// Time Complexity = O(n) where n = length of the longest string.
// Space Complexity = O(1) ∵ in english alphabet we have only 26 character.
