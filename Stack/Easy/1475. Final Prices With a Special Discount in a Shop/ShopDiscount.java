import java.util.Stack;

public class ShopDiscount {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3}; // Example input
        int[] discountedPrices = finalPrices(prices);

        // Output the result
        for (int price : discountedPrices) {
            System.out.print(price + " ");
        }
    }

    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            // While the current price is less than or equal to the price at the top of the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        // For remaining items in the stack, the price remains the same
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices[index];
        }

        return answer;
    }
}
