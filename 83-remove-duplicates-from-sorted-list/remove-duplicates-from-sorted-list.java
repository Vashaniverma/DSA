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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        if(head==null){
            return head;
        }
        dummy.next=head;
        ListNode temp1=head;
        ListNode temp2=temp1.next;

        while(temp2!=null){
            if(temp1.val==temp2.val){
                temp2=temp2.next;
            }
            else{
                temp1.next=temp2;
                temp1=temp2;
                temp2=temp2.next;
            }
            if(temp2==null){
                temp1.next=null;
            }
        }
        return dummy.next;
    }
}