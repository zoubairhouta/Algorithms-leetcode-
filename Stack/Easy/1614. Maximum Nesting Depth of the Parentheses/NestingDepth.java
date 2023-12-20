import java.util.Stack;

public class NestingDepth {
    // Method to calculate the maximum depth of a valid parentheses string
    public static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>(); // Create a stack to track opening parentheses
        int maxDepth = 0; // Initialize a variable to keep track of the maximum depth

        // Iterate through each character of the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character

            if (c == '(') {
                // If the current character is an opening parenthesis, push it onto the stack
                stack.push(c);
            } else if (c == ')') {
                // If the current character is a closing parenthesis
                maxDepth = Math.max(maxDepth, stack.size()); // Update the maxDepth with the current stack size
                stack.pop(); // Pop the top element from the stack
            }
            // Note: Characters other than '(' and ')' are ignored as they do not affect the depth
        }

        return maxDepth; // Return the maximum depth found
    }

    public static void main(String[] args) {
        // Test the method with a couple of example strings
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println("The nesting depth of '" + s1 + "' is: " + maxDepth(s1));

        String s2 = "(1)+((2))+(((3)))";
        System.out.println("The nesting depth of '" + s2 + "' is: " + maxDepth(s2));
    }
}
