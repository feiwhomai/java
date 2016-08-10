/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
package leetcode;

import leetcode.util.TreeNode;

public class LeetCode104MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {

        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

}
