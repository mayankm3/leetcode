package solutions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeInorderTraversal1 {

    // The time complexity is O(n)
    // The worst case space required is O(n), and in the average case it's O(h) where h=height of tree
    // https://stackoverflow.com/questions/41201908/why-is-the-space-complexity-of-a-recursive-inorder-traversal-oh-and-not-on

    private class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> myList = new ArrayList<>();
        inorderTraversal(root, myList);
        return myList;
    }

    private void inorderTraversal(TreeNode root, List<Integer> myLi){
        if (root == null) return;
        inorderTraversal(root.left, myLi);
        myLi.add(root.val);
        inorderTraversal(root.right, myLi);
    }
}
