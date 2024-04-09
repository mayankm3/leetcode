package solutions.easy.again;

public class LinkedListCycle {
    // https://leetcode.com/problems/linked-list-cycle/description/
    // https://leetcode.com/problems/linked-list-cycle/solutions/44489/o-1-space-solution/
    // Floyd's tortoise and hare algorithm
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val=x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head==null) return false;

        ListNode slow = head;
        ListNode fast = head;

        // not including slow.next here is very clever, becomes clear if you understand with an example
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast) return true;
        }

        return false;
    }
}
