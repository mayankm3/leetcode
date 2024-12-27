package solutions.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths1 {

    // https://leetcode.com/problems/binary-tree-paths/
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
        List<String> internalList = new ArrayList<>(100);
        dfsPath(root, result, internalList);
        return result;
    }

    private void dfsPath(TreeNode treeNode, List<String> listOfAllPaths, List<String> listOfNodes){
        listOfNodes.add(String.valueOf(treeNode.val));

        if (treeNode.left == null && treeNode.right == null) {
            String finalPath = "";
            String arrow = "->";

            for (int i = 0; i < listOfNodes.size() - 1; i++) {
                finalPath += (listOfNodes.get(i) + arrow);
            }
            finalPath += listOfNodes.get(listOfNodes.size() - 1);
            listOfAllPaths.add(finalPath);
            return;
        }

        if (treeNode.left != null) {
            dfsPath(treeNode.left, listOfAllPaths, listOfNodes);
            listOfNodes.remove(listOfNodes.size() - 1);
        }

        if (treeNode.right != null) {
            dfsPath(treeNode.right, listOfAllPaths, listOfNodes);
            listOfNodes.remove(listOfNodes.size() - 1);
        }
    }
}
