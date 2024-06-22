package solutions.medium.again;

public class DeleteNodeInALinkedList {

    // https://leetcode.com/problems/delete-node-in-a-linked-list/solutions/65455/1-3-lines-c-java-python-c-c-javascript-ruby/
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
