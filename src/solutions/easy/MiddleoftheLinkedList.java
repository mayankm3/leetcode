package solutions.easy;

public class MiddleoftheLinkedList {

    // https://leetcode.com/problems/middle-of-the-linked-list/description/
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = fast.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
