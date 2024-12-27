package solutions.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths3 {

    // https://leetcode.com/problems/binary-tree-paths/
    // https://leetcode.com/problems/binary-tree-paths/solutions/68258/accepted-java-simple-solution-in-8-lines/comments/70164
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfsPath(root, result, stringBuilder);
        return result;
    }

    private void dfsPath(TreeNode treeNode, List<String> listOfAllPaths, StringBuilder stringBuilder){
        if(treeNode == null)  return;

        int sbLength = stringBuilder.length();
        stringBuilder.append(treeNode.val);

        if (treeNode.left == null && treeNode.right == null){
            listOfAllPaths.add(stringBuilder.toString());
        }
        else{
            stringBuilder.append("->");
            dfsPath(treeNode.left, listOfAllPaths, stringBuilder);
            dfsPath(treeNode.right, listOfAllPaths, stringBuilder);
        }

        stringBuilder.setLength(sbLength);
    }
}
