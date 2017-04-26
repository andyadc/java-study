package com.andyadc.datastructure.tree;

/**
 * @author andaicheng
 * @version 2017/4/26
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(4);

        right.left = right1;
        right.right = right2;

        root.left = left;
        root.right = right;

        System.out.println(maxDepth(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }
}
