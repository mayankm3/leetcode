package solutions.medium.again;

public class CopyListwithRandomPointer {

    // https://leetcode.com/problems/copy-list-with-random-pointer/description/
    // GPT assisted solution
    // I was unable to arrange code lines for step 3, although I had written the code
    // TC: O(N)
    // SC: O(N). The question demands a copy, https://www.youtube.com/watch?v=q570bKdrnlw
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node current = head, copy;

        // Step 1: Interleave the original list with copied nodes but without random
        //  A --> A' --> B --> B' --> C --> C' --> D --> D' from leetcode hints
        while (current != null){
            copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // Step 2: Copy the random pointers
        current = head;
        while (current != null){
            copy = current.next;
            if (current.random != null) {
                copy.random = current.random.next;  // connecting to random prime
            }

            current = copy.next;    // or current.next.next;
        }

        // Step 3: Separate the two lists
        Node original = head;
        Node headOfCopy = head.next; // The head of the copied list
        copy = headOfCopy;
        while (original != null){
            original.next = original.next.next;

            if (copy.next != null){
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return headOfCopy;
    }
}
