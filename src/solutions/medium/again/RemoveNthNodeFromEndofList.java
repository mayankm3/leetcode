package solutions.medium.again;

public class RemoveNthNodeFromEndofList {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    // Time complexity:O(N)
    // Space complexity:O(1)
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        // to make fast n positions ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // For TC where head = [1] & n=1
        // For TC where head = [1, 2] & n=2
        if(fast==null) return head.next;

        // now moving at same pace
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        // slow.next = fast fails for TC where head = [1,2] & n=1
        slow.next = slow.next.next;

        return head;
    }

}
