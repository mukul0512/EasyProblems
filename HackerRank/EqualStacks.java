/*

 * You are given three stacks of cylinders, where each cylinder has some height.
 * Your task is to equalize the height of all three stacks by removing cylinders
 * from the top.
 * 
 * Rules:
 * 
 * You can only remove cylinders from the top of a stack.
 * You must find the maximum possible height at which all three stacks can be
 * equal.
 * Input:
 * 
 * Three integer arrays: h1, h2, and h3, representing the heights of cylinders
 * in each stack (from bottom to top).
 * Output:
 * 
 * An integer representing the maximum equal height that can be achieved.
 * Example 1
 * Input:
 * h1 = [3, 2, 1, 1, 1]
 * h2 = [4, 3, 2]
 * h3 = [1, 1, 4, 1]
 * Process:
 * Initial stack heights:
 * Stack 1: 3 → 5 → 6 → 7 → 8
 * Stack 2: 4 → 7 → 9
 * Stack 3: 1 → 2 → 6 → 7
 * Remove the top element from stack 2 (height 9 → 7).
 * Remove the top element from stack 1 (height 8 → 7).
 * Now, all stacks are at height 7.
 * Output:
 * 7
 
 */
package HackerRank;

import java.util.Stack;

public class EqualStacks {

    public int equalStacks(int[] h1, int[] h2, int[] h3) {
        int maxHeight = 0;

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        fillStacks(st1, h1, st2, h2, st3, h3);

        // Run a loop until every stack has at least one element
        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {
            int stack1Height = st1.peek();
            int stack2Height = st2.peek();
            int stack3Height = st3.peek();

            // If all stacks are of same height, return the height
            if (stack1Height == stack2Height && stack2Height == stack3Height) {
                maxHeight = stack1Height;
                break;
            }

            // Remove the top element from the tallest stack
            if (stack1Height >= stack2Height && stack1Height >= stack3Height) {
                st1.pop();
            } else if (stack2Height >= stack1Height && stack2Height >= stack3Height) {
                st2.pop();
            } else {
                st3.pop();
            }
        }

        return maxHeight;
    }

    private void fillStacks(Stack<Integer> st1, int[] h1, Stack<Integer> st2, int[] h2, Stack<Integer> st3, int[] h3) {
        int st1TotalHeight = 0, st2TotalHeight = 0, st3TotalHeight = 0;

        // Store cumulative height in the stack instead of individual cylinder height
        for (int i = h1.length - 1; i >= 0; i--) {
            st1TotalHeight += h1[i];
            st1.push(st1TotalHeight);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            st2TotalHeight += h2[i];
            st2.push(st2TotalHeight);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            st3TotalHeight += h3[i];
            st3.push(st3TotalHeight);
        }
    }

    public static void main(String[] args) {
        EqualStacks obj = new EqualStacks();

        // Sample test case
        int[] h1 = { 3, 2, 1, 1, 1 };
        int[] h2 = { 4, 3, 2 };
        int[] h3 = { 1, 1, 4, 1 };

        int result = obj.equalStacks(h1, h2, h3);
        System.out.println("Maximum Equal Height: " + result);
    }
}

// Time Complexity = O(n1 + n2 + n3)
// Space Complexity = O(n1 + n2 + n3)
