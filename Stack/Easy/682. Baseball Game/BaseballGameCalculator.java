import java.util.Stack;

public class BaseballGameCalculator {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            switch (op) {
                case "+":
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    break;
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }

    // Main method for testing
    public static void main(String[] args) {
        BaseballGameCalculator calculator = new BaseballGameCalculator();
        String[] ops = {"5","2","C","D","+"}; // Example input
        int result = calculator.calPoints(ops);
        System.out.println("Total score: " + result); // Output the result
    }
}
