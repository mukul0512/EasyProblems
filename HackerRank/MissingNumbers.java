/*
 * 
 * You are given two arrays:
 * 
 * brr – the original list containing all elements.
 * arr – the modified list with some numbers removed.
 * Your task is to find the missing numbers that are present in brr but not in
 * arr.
 * 
 * A number is considered missing if its frequency in brr is greater than its
 * frequency in arr.
 * The output should be sorted in ascending order.
 * If multiple numbers are missing, return them in sorted order.
 * The input numbers can be large, so an efficient solution is required.
 * Example 1
 * Input:
 * arr = [203, 204, 205, 206, 207, 208, 203, 204, 205, 206]
 * brr = [203, 204, 204, 205, 206, 207, 208, 203, 204, 205, 206, 205, 204]
 * Output:
 * Missing Numbers: 204 205
 * Explanation:
 * 204 appears 3 times in brr but only 2 times in arr.
 * 205 appears 3 times in brr but only 2 times in arr.
 * So, 204 and 205 are missing.
 * Example 2
 * Input:
 * arr = [1, 2, 3, 4, 5]
 * brr = [1, 2, 3, 4, 5, 5, 6]
 * Output:
 * Missing Numbers: 5 6
 * Explanation:
 * 5 appears twice in brr but only once in arr.
 * 6 appears in brr but is completely missing in arr.
 * Constraints:
 * 1 ≤ |arr|, |brr| ≤ 2 × 10^5 (up to 200,000 elements)
 * 1 ≤ arr[i], brr[i] ≤ 10^4 (numbers range from 1 to 10,000)
 * brr contains at least all elements of arr, but arr may be missing some.
 * 
 */

package HackerRank;

import java.util.Map;
import java.util.TreeMap;

public class MissingNumbers {
    public int[] missingNumbers(int[] arr, int[] brr) {

        TreeMap<Integer, Integer> integerFreqMap = new TreeMap<>();

        // Add elements of original list
        for (int i : brr) {
            int freq = integerFreqMap.getOrDefault(i, 0);
            freq++;
            integerFreqMap.put(i, freq);
        }

        // Remove elements of new list
        for (int i : arr) {
            int freq = integerFreqMap.get(i);
            freq--;
            if (freq == 0)
                integerFreqMap.remove(i);
            else
                integerFreqMap.put(i, freq);
        }

        // Create the result array
        int[] result = new int[integerFreqMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : integerFreqMap.entrySet()) {
            result[i++] = integerIntegerEntry.getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        MissingNumbers obj = new MissingNumbers();

        // Sample test cases
        int[] arr = { 7, 2, 5, 3, 5, 3 };
        int[] brr = { 7, 2, 5, 4, 6, 3, 5, 3 };

        int[] missingNumbers = obj.missingNumbers(arr, brr);

        // Print the missing numbers
        System.out.print("Missing Numbers: ");
        for (int num : missingNumbers) {
            System.out.print(num + " ");
        }
    }
}
