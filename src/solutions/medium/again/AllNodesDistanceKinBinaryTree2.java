package solutions.medium.again;

import java.util.*;

public class AllNodesDistanceKinBinaryTree2 {

    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree
    // I was only able to find downward distances
    // This solution is primarily based on https://www.youtube.com/watch?v=i9ORlEy6EsI and
    // solutions with 13 ms runtime
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> childAndParent = new HashMap<>();
        createChildAndParentMap(root, childAndParent);

        Set<TreeNode> visitedSet = new HashSet<>();
        visitedSet.add(target);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);    // add(TreeNode) if the queue is full (in bounded queues), it throws an exception (IllegalStateException)
                                // offer(TreeNode) if the queue is full (in bounded queues), it returns false.
        int currDistance = 0;
        while (!queue.isEmpty()){
            if (currDistance == k) break;
            currDistance++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                TreeNode leftNode = treeNode.left;
                if (leftNode != null && !visitedSet.contains(leftNode)){
                    queue.offer(leftNode);
                    visitedSet.add(leftNode);
                }

                TreeNode rightNode = treeNode.right;
                if (rightNode != null && !visitedSet.contains(rightNode)){
                    queue.offer(rightNode);
                    visitedSet.add(rightNode);
                }

                TreeNode parentNode = childAndParent.get(treeNode);
                if (parentNode != null && !visitedSet.contains(parentNode)){
                    queue.offer(parentNode);
                    visitedSet.add(parentNode);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (TreeNode treeNode: queue) result.add(treeNode.val);
        return result;
    }

    // lesser memory
    private void createChildAndParentMap(TreeNode root, Map<TreeNode, TreeNode> childAndParent) {
        TreeNode leftNode = root.left;
        if (leftNode != null){
            childAndParent.put(leftNode, root);
            createChildAndParentMap(leftNode, childAndParent);
        }

        TreeNode rightNode = root.right;
        if (rightNode != null){
            childAndParent.put(rightNode, root);
            createChildAndParentMap(rightNode, childAndParent);
        }

    }

}
