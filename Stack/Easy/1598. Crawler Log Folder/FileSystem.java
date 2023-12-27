import java.util.Stack;

public class FileSystem {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!log.equals("./")) {
                stack.push(log);
            }
        }
        // algo 3azzab hakkeka 

        return stack.size();
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        String[] logs1 = {"d1/","d2/","../","d21/","./"};
        System.out.println("Example 1: " + fileSystem.minOperations(logs1));

        String[] logs2 = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println("Example 2: " + fileSystem.minOperations(logs2));

        String[] logs3 = {"d1/","../","../","../"};
        System.out.println("Example 3: " + fileSystem.minOperations(logs3));
    }
}
