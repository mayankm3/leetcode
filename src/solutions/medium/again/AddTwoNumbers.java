package solutions.medium.again;

public class AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/description
    // Time complexity : O(max(m,n). Assume that m and n represents the length of l1 and l2 respectively
    // Space complexity : O(1). The length of the new list is at most max(m,n)+1
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead  = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1!=null || l2!=null || carry !=0){
            int l1Num = ( l1!=null? l1.val:0);
            int l2Num = ( l2!=null? l2.val:0);

            int sum = l1Num + l2Num + carry;
            int digit = sum%10; // remainder
            carry = sum/10; // quotient

            ListNode intermed = new ListNode(digit);
            current.next = intermed;
            current = current.next;


            l1 = (l1!=null? l1.next:null);
            l2 = (l2!=null? l2.next:null);

            // or you can do below
//            if (l1 != null)
//                l1 = l1.next;
//            if (l2 != null)
//                l2 = l2.next;
        }

        return dummyHead.next;
    }
}
