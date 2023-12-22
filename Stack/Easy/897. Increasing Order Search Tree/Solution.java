// Solution.java
import java.util.Stack;

public class Solution {
    private TreeNode prev = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        TreeNode dummyNode = new TreeNode(0); // Dummy node
        prev = dummyNode;

        inOrder(root);

        return dummyNode.right;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left); // Traverse left subtree

        node.left = null; // Set the left child to null
        prev.right = node; // Link the previous node's right to the current node
        prev = node; // Update the previous node

        inOrder(node.right); // Traverse right subtree
    }

    public static void main(String[] args) {
        // Creating an example tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        // Transform the tree
        Solution solution = new Solution();
        TreeNode newRoot = solution.increasingBST(root);

        // Print the transformed tree
        printTree(newRoot);
    }

    private static void printTree(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}
