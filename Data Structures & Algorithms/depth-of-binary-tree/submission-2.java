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
//Using DFS
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null) return 0;
//         return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
        
//     }
// }

//Using BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
        depth++;
      }
      return depth;  
    }
}

