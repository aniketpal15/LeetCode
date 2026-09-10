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
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodesCount = 0;
        dfs(root);
        return matchingNodesCount;
    }

    // Helper method returns an array: [subtree_sum, subtree_count]
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int currSum = node.val + left[0] + right[0];
        int currCount = 1 + left[1] + right[1];

        // Integer division automatically rounds down towards zero
        if (node.val == currSum / currCount) {
            matchingNodesCount++;
        }

        return new int[]{currSum, currCount};
    }
}