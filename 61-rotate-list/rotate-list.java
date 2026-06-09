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
    public ListNode rotateRight(ListNode head, int k) {
        int count=0;
        if(head==null ||head.next==null){
            return head;
        }
        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;
        
        while(count!=k){
            ListNode temp=head;
            count++;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            ListNode last=temp;
            temp=temp.next;
            temp.next=head;
            head=temp;
            last.next=null;
        }
        return head;
    }
}