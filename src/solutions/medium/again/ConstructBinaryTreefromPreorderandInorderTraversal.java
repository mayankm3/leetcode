package solutions.medium.again;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    // https://www.youtube.com/watch?v=aZNaLrVebKQ
    // A tough question indeed, I was unable to find the first relationship between the two arrays which Raj showed
    // Pointer manipulation is also tough
    // TC: O(n)
    // SC: O(n)
    private static class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> integerMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            integerMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1,
                integerMap);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart>preEnd || inStart>inEnd) return null;

        int nodeValue = preorder[preStart];
        TreeNode root = new TreeNode(nodeValue);
        int indexInInorder = map.get(nodeValue);
        int leftTreeSize  = indexInInorder - inStart;

        root.left = buildTreeHelper(preorder, preStart+1, preStart+leftTreeSize ,
                inorder, inStart, indexInInorder-1,
                map);

        root.right = buildTreeHelper(preorder, preStart+leftTreeSize +1, preEnd,
                inorder, indexInInorder+1, inEnd,
                map);

        return root;
    }


}
