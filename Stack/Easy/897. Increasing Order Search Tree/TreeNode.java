public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        TreeNode dummyNode = new TreeNode(-1); // Dummy node to ease the re-linking process
        TreeNode current = dummyNode;
        Stack<TreeNode> stack = new Stack<>();

        // In-order traversal
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; // move to the leftmost node
            }
            root = stack.pop();
            root.left = null; // set the left child to null
            current.right = root; // link the current node to the right child of the last node
            current = root; // move current to the right
            root = root.right; // process the right subtree
        }

        return dummyNode.right; // return the right child of the dummy node
    }
}
