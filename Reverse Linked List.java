/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        if(head == null || head.next == null )
            return head;
        ListNode ahead = head.next;
        while(ahead != null) {
            curr.next = prev;
            prev = curr;
            curr = ahead;
            
            ahead = ahead.next;
        }
        curr.next = prev;
        return curr;
    }
}
