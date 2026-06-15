/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode prv=null;
        while(fast!=null && fast.next!=null){
            prv=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(head.next==null){
            return null;
        }
        prv.next=prv.next.next;
        return head;
    }
}