package solutions.medium.again;

public class ReverseLinkedListII1 {

    // https://leetcode.com/problems/reverse-linked-list-ii/solutions/2311084/java-c-tried-to-explain-every-step/
    // https://www.youtube.com/watch?v=oDL8vuu2Q0E
    // TC: O(n)
    // SC: O(1)
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // create a dummy node to mark the head of this list
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // make markers for currentNode and for the node before reversing
        ListNode leftPre = dummyNode, currentNode = head;

        for (int i = 1; i < left; i++) {
            leftPre = leftPre.next;
            currentNode = currentNode.next;
        }

        // make a marker to node where we start reversing
        ListNode initialLeftNode = currentNode;

        ListNode previousNode = null;
        for (int i = 0; i <= right-left; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        // Join the pieces
        leftPre.next = previousNode;
        initialLeftNode.next = currentNode;

        return dummyNode.next;
    }
}
