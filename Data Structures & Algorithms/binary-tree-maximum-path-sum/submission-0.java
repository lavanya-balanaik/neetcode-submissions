/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Ignore negative paths
        int left = Math.max(0, dfs(node.left));

        int right = Math.max(0, dfs(node.right));

        // Path THROUGH current node
        int currentPath = left + right + node.val;

        // Update global answer
        maxSum = Math.max(maxSum, currentPath);

        // Return ONE side upward
        return node.val + Math.max(left, right);
    }
}