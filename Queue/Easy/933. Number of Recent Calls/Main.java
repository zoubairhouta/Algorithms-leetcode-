import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    // Initialize a queue to store timestamps
    private Queue<Integer> requests;

    public RecentCounter() {
        // Initialize the queue in the constructor
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the current timestamp to the rear of the queue
        requests.add(t);

        // Remove requests from the front that are outside the time frame [t - 3000, t]
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the size of the queue (number of requests within the time frame)
        return requests.size();
    }
}

public class Main {
    public static void main(String[] args) {
        // Example Usage:
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // Output: 1
        System.out.println(recentCounter.ping(100));   // Output: 2
        System.out.println(recentCounter.ping(3001));  // Output: 3
        System.out.println(recentCounter.ping(3002));  // Output: 3
    }
}
