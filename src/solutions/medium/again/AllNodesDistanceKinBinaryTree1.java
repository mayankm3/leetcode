package solutions.medium.again;

import java.util.*;

public class AllNodesDistanceKinBinaryTree1 {

    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
    // I was only able to find downward distances
    // This solution is primarily based on https://www.youtube.com/watch?v=i9ORlEy6EsI
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> childAndParent = new HashMap<>();
        bfsCreateChildAndParentMap(root, childAndParent);

        Map<TreeNode, Boolean> treeNodeVisitedMap = new HashMap<>();
        treeNodeVisitedMap.put(target, true);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        int currDistance = 0;
        while (!queue.isEmpty()){
            if (currDistance == k) break;
            currDistance++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                TreeNode leftNode = treeNode.left;
                if (leftNode != null && treeNodeVisitedMap.get(leftNode) == null){
                    queue.add(leftNode);
                    treeNodeVisitedMap.put(leftNode, true);
                }

                TreeNode rightNode = treeNode.right;
                if (rightNode != null && treeNodeVisitedMap.get(rightNode) == null){
                    queue.add(rightNode);
                    treeNodeVisitedMap.put(rightNode, true);
                }

                TreeNode parentNode = childAndParent.get(treeNode);
                if (parentNode != null && treeNodeVisitedMap.get(parentNode) == null){
                    queue.add(parentNode);
                    treeNodeVisitedMap.put(parentNode, true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        queue.forEach(treeNode -> result.add(treeNode.val));
        return result;
    }

    private void bfsCreateChildAndParentMap(TreeNode root, Map<TreeNode, TreeNode> childAndParent) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();  // Retrieves and removes

            TreeNode leftNode = treeNode.left;
            if (leftNode != null){
                queue.add(leftNode);
                childAndParent.put(leftNode, treeNode);
            }

            TreeNode rightNode = treeNode.right;
            if (rightNode != null){
                queue.add(rightNode);
                childAndParent.put(rightNode, treeNode);
            }
        }
    }

}
