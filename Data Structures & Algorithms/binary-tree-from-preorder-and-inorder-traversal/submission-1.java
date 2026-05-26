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

    int preorderIndex = 0;

    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder,
                           int left,
                           int right) {

        if (left > right) {
            return null;
        }

        // root from preorder
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // split point in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // build left subtree
        root.left = build(preorder,
                          left,
                          inorderIndex - 1);

        // build right subtree
        root.right = build(preorder,
                           inorderIndex + 1,
                           right);

        return root;
    }
}