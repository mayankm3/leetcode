package solutions.medium.again;

public class RotateList {

    // https://leetcode.com/problems/rotate-list/description/
    // Based on successive hints by GPT.
    // Most crucial hint was int indexOfNewTail = listSize - rotateTimes - 1; I solved it after that.
    // TC: O(n)
    // SC: O(1)
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // divide k by length and remainder is how many times to rotate
        int listSize = 1;
        ListNode tail = head;
        while (tail.next!=null){
            listSize++;
            tail = tail.next;
        }
        int rotateTimes = k % listSize; // you can also reassign this to k, consumes less memory
        if (rotateTimes == 0) return head; // 2 % 5 = 2 or 0 % 5 = 0

        int indexOfNewTail = listSize - rotateTimes - 1; // 5-2-1=2 (index)
        ListNode newTail = head;
        for (int i = 0; i < indexOfNewTail; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
