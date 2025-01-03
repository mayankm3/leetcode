package solutions.hard.again;

public class ReverseNodesInKGroup {

    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    // https://www.youtube.com/watch?v=lIar1skcQYI
    // Below is GPT's cleaner solution, I understood with above youtube example by drawing myself
    // TC: O(n)
    // SC: O(1)
    // My solution looked like below iterative solution. But I was unable to wire the pointers
    // https://leetcode.com/problems/reverse-nodes-in-k-group/solutions/523641/c-iterative-solution-recursive-solution-41ukf/
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Create a dummy node to help with edge cases.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Check if there are k nodes left in the list to reverse
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) break;  // Less than k nodes, no reversal

            // Store the node after the k-group to connect later
            ListNode groupNext = kthNode.next;

            // Reverse the group of k nodes
            ListNode groupHead = groupPrev.next;
            groupPrev.next = reverseGroup(groupHead, k);    // First time groupPrev.next is dummy, then groupPrev.next is 3, then groupPrev.next is 6...

            // After reversing, the groupHead is now the tail of the reversed group
            groupHead.next = groupNext;

            // Move groupPrev to the new tail of the reversed group
            groupPrev = groupHead;
        }

        return dummy.next;
    }

    // Helper method to find the kth node starting from a given node
    private ListNode getKthNode(ListNode start, int k) {
        ListNode curr = start;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
            if (curr == null) return null;
        }
        return curr;
    }

    // Private function to reverse a linked list of k nodes
    private ListNode reverseGroup(ListNode head, int k) {
        ListNode previousNode = null;
        ListNode curr = head;
        ListNode nextNode = null;

        for (int i = 0; i < k; i++) {
            nextNode = curr.next;
            curr.next = previousNode;
            previousNode = curr;
            curr = nextNode;
        }

        return previousNode;  // After k iterations, 'previousNode' will be the new head of the reversed group
    }

}
