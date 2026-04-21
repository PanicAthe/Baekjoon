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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = l1.val + l2.val;
        int carry = sum / 10;
        
        // root
        ListNode result = new ListNode(sum % 10);
        ListNode cur = result;
        
        while(l1.next != null || l2.next != null){
            sum = carry;

            if(l1.next != null){
                l1 = l1.next;
                sum += l1.val;
            }

            if(l2.next != null){
                l2 = l2.next;
                sum += l2.val;
            }

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return result;
    }
}