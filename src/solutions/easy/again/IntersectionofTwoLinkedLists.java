package solutions.easy.again;

public class IntersectionofTwoLinkedLists {

    // https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
    // https://www.youtube.com/watch?v=u4FWXfgS8jw&t=725s
    // TC:O(M+N) or O(max(M,N))
    // SC: O(1)
    //
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val=x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode a = headA, b= headB;

        while (a!=b){
            a = (a==null? headB:a.next);
            b = (b==null? headA:b.next);
        }

        return a;
    }
}
