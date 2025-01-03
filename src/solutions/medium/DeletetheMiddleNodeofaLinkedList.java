package solutions.medium;

public class DeletetheMiddleNodeofaLinkedList {

    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode slow = head, fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }
}
