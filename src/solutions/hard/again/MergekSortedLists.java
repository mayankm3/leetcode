package solutions.hard.again;

import java.util.PriorityQueue;

public class MergekSortedLists {

    // https://leetcode.com/problems/merge-k-sorted-lists/description/
    // GPT assisted solution
    // https://www.youtube.com/watch?v=1zktEppsdig
    // TC: O(k*logk) + O(k*N*logk); k = size of lists or PriorityQueue
    // SC: O(k); k = size of lists or PriorityQueue
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // To store the smallest elements of all the lists and efficiently extract the minimum one at each step.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (x, y) -> x.val - y.val);

        // placing the first, smallest, element from each list into the heap
        for (ListNode eachList : lists) {
            if (eachList != null) {
                minHeap.add(eachList);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()){
            ListNode poppedMin = minHeap.remove();
            current.next = poppedMin;

            // If the node has a next node, add it to the heap
            if (poppedMin.next != null){
                minHeap.add(poppedMin.next);
            }

            current = current.next;
        }

        return dummy.next;
    }
}
