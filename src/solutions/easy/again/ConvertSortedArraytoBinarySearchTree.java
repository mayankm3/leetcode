package solutions.easy.again;

public class ConvertSortedArraytoBinarySearchTree {

    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
    // https://www.youtube.com/watch?v=0K0uCMYq5ng
    // Time complexity: O(N) since we visit each node exactly once.
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;

        return construct(nums, 0, nums.length -1);  // nums.length -1 is for right pointer
    }

    private TreeNode construct(int[] intArray, int low, int high){
        if(low>high){
            return null;
        }

        int mid = (low + high)/2;
        TreeNode treeNode = new TreeNode(intArray[mid]);
        treeNode.left = construct(intArray, low, mid-1);
        treeNode.right = construct(intArray, mid+1, high);

        return treeNode;
    }
}
