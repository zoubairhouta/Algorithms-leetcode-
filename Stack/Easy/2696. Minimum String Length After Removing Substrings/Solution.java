import java.util.Stack;

public class Solution {
    public static int minimumLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ((ch == 'B' && stack.peek() == 'A') || (ch == 'D' && stack.peek() == 'C'))) {
                stack.pop(); // Remove the pair
            } else {
                stack.push(ch); // Add the character to the stack
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        String s1 = "ABFCACDB";
        System.out.println(minimumLength(s1)); // Output: 2

        String s2 = "ACBBD";
        System.out.println(minimumLength(s2)); // Output: 5
    }
}
