package solutions.easy.again;

public class ReverseLinkedList {

    // https://leetcode.com/problems/reverse-linked-list
    // TC: O(n)
    // SC: O(1)
    // https://youtu.be/3IN0BP9Ni6E&t=420
    // https://www.youtube.com/watch?v=NCilGMhdYPY
    // iterative solution
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head!=null){
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }

        return newHead;
    }
}
