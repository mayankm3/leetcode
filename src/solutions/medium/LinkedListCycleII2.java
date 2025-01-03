package solutions.medium;

public class LinkedListCycleII2 {

    // https://leetcode.com/problems/linked-list-cycle-ii/description/
    // My solution, could solve only when I saw that topics has HashTable
    // https://www.youtube.com/watch?v=95ZfuoSAUPI
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isCycle = false;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) return null;

        fast = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
