/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;   //prev is needed to end the first half in two
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        return merge(l1, l2);
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode prev = newHead;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        while(l1 != null) { //can replace while by if, we know that both sublists will at most differ by 1 in length
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
        }
        while(l2 != null) {
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }
        return newHead.next;
    }
}
