package solutions.medium;

import java.util.HashSet;

public class LinkedListCycleII1 {

    // https://leetcode.com/problems/linked-list-cycle-ii/description/
    // My solution, could solve only when I saw that topics has HashTable
    // See other solution, it's much better
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        HashSet<ListNode> nodeHashSet = new HashSet<>();
        ListNode slow = head;

        while (slow.next != null){
            if (!nodeHashSet.contains(slow)){
                nodeHashSet.add(slow);
            }
            else return slow;

            slow = slow.next;
        }

        return null;
    }
}
