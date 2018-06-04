/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val)
                    return -1;
                else if(o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        
        ListNode newHead = new ListNode(0);
        ListNode head = newHead;
        for(ListNode temp:lists) {  //first add all the heads of the list
            if(temp != null)
                q.add(temp);
        }
        
        while(!q.isEmpty()) {
            head.next = q.poll();
            head = head.next;
            
            if(head.next != null) //after polling a node, see if there is a next node in that list and add it
                q.add(head.next);
        }
        return newHead.next;
    }
}
