package solutions.easy.again;

public class MergeTwoSortedLists {
    // https://leetcode.com/problems/merge-two-sorted-lists/solutions/9772/java-solution-with-real-world-concerns-real-world-concerns/
    // https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
    // https://media.geeksforgeeks.org/wp-content/cdn-uploads/20220303143032/Merge-Two-Sorted-LinkedLists1.jpg

    // https://www.youtube.com/watch?v=GfRQvf7MB3k

    // https://www.youtube.com/watch?v=KVf1Uuqfv8E
    // See comment section

    // https://youtu.be/g_uxlc8C6HE?t=66
    // Let N be the number of nodes in list l1 and M be the number of nodes in list l2.
    // We have to iterate through both lists. So, the total time complexity is O(N+M).
    // https://stackoverflow.com/questions/16495034/big-o-complexity-to-merge-two-lists
    // Space complexity is O(1). We just rewired.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyList = new ListNode(0);
        ListNode current = dummyList;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                current.next = list1;   // The node reference is getting appended.
                list1 = list1.next;
            }
            else {
                current.next = list2;   // it is a reference to a pointer which holds the full data.
                list2 = list2.next;
            }
            current = current.next; // current hopping to what it just pointed itself to i.e., a new Node
        }

        current.next = (list1 == null? list2:list1);

        return dummyList.next;
    }
}