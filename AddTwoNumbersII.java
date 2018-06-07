/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum, carry = 0;
        ListNode head = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()) {
            sum = carry;
            if(!s1.isEmpty())
                sum = sum + s1.pop();
            if(!s2.isEmpty())
                sum = sum + s2.pop();
            
            int val = sum % 10;
            carry = sum / 10;
            head.val = val;
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head.val == 0 ? head.next : head;
    }
}
