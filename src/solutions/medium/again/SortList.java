package solutions.medium.again;

public class SortList {

    // https://leetcode.com/problems/sort-list/
    // https://leetcode.com/problems/sort-list/solutions/46714/java-merge-sort-solution/
    // https://leetcode.com/problems/sort-list/solutions/46772/i-have-a-pretty-good-mergesort-method-can-anyone-speed-up-the-run-time-or-reduce-the-memory-usage/
    // TC: O(nlogn)
    // SC: O(logn) stack space.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;

        ListNode prev = null, slow=head, fast=head;

        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0), currentNode = dummyHead;

        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }

            currentNode = currentNode.next;
        }

        if (l1==null){
            currentNode.next = l2;
        }
        if (l2==null){
            currentNode.next = l1;
        }

        return dummyHead.next;
    }
}
