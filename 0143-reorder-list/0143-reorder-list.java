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
    public void reorderList(ListNode head) {
        // find the middle
        ListNode slow = head, fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        
        // reverse the second half
        ListNode current = slow.next;
        slow.next = null; 
        ListNode prev = null;
        while(current != null){
            ListNode temp = current.next; 
            current.next = prev;
            prev = current;
            current = temp; 
        }

        // merge the two halves
        ListNode l1 = head, l2 = prev;
        while(l2 != null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}