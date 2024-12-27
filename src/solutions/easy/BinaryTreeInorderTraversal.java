package solutions.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

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
        inorderTraversal(root.left, myLi);  // if root.left is null then it won't throw any exception
                                            // but null.left will throw an exception. However, the first if() prevents it
        // GPT: root.left and root.right are just references to child nodes, which may either be another TreeNode or
        // null if the left or right child is absent.
        myLi.add(root.val);
        inorderTraversal(root.right, myLi);
    }
}
