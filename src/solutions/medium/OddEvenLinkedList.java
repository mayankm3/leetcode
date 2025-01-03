package solutions.medium;

public class OddEvenLinkedList {

    // https://leetcode.com/problems/odd-even-linked-list/description/
    // https://www.youtube.com/watch?v=WoUAs7R3Ao4
    // TC: O(n)
    // SC: O(1)
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = odd.next, evenHead = even;

        while (even != null && even.next != null){    // Arrive at this condition after taking examples of a list with 3, 4 and 7 elements
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
