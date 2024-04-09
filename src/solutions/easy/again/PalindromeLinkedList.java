package solutions.easy.again;

public class PalindromeLinkedList {

    // https://leetcode.com/problems/palindrome-linked-list/description
    // https://www.youtube.com/watch?v=WyI5dXMHW5c
    // TC: O(n)
    // SC: O(1)
    // https://www.youtube.com/watch?v=lRY_G-u_8jk (reverse back)
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast!=null){
            slow = slow.next;   // odd number of nodes, let right half be smaller
        }

        slow = reverse(slow);   // reversing the second half
        fast = head;    // resetting fast pointer

        while (slow != null){
            if (fast.val != slow.val) return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode ln){
        ListNode reversed = null;

        while (ln!=null){
            ListNode nextSaved = ln.next;
            ln.next = reversed;
            reversed = ln;
            ln = nextSaved;
        }

        return reversed;
    }
}
