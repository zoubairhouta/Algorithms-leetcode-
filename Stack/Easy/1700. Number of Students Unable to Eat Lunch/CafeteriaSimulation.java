import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CafeteriaSimulation {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentQueue = new ArrayDeque<>();
        Stack<Integer> sandwichStack = new Stack<>();

        for (int student : students) {
            studentQueue.addLast(student);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }

        int noMatchCounter = 0;
        while (!sandwichStack.isEmpty() && noMatchCounter < studentQueue.size()) {
            if (studentQueue.peekFirst().equals(sandwichStack.peek())) {
                studentQueue.removeFirst();
                sandwichStack.pop();
                noMatchCounter = 0;
            } else {
                studentQueue.addLast(studentQueue.removeFirst());
                noMatchCounter++;
            }
        }
        // 9ana3acd
        // commentaire ekher

        return studentQueue.size();
    }

    public static void main(String[] args) {
        CafeteriaSimulation cs = new CafeteriaSimulation();
        System.out.println(cs.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1})); // Output: 0
        System.out.println(cs.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1})); // Output: 3
    }
}
