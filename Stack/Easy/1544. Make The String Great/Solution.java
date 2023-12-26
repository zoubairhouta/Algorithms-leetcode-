import java.util.Stack;
public class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                // If the current character and the top of the stack are a "bad" pair,
                // pop the top character from the stack.
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack.
                stack.push(c);
            }
        }

        // Reconstructing the "good" string from the stack.
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("leEeetcode")); // Output: "leetcode"
        System.out.println(solution.makeGood("abBAcC"));     // Output: ""
        System.out.println(solution.makeGood("s"));          // Output: "s"
    }
}
