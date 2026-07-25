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
        ListNode head = null;
        ListNode temp = null;
        int carry =0;
        while(l1!= null || l2!= null||carry!=0){
            int num1 = (l1==null)?0:l1.val;
            int num2 = (l2==null)?0:l2.val;
            int sum = num1 +num2+carry;
            ListNode newnode = new ListNode(sum%10);
            carry = sum/10;
            if(head==null){
                head = newnode;
                temp = newnode;
            }else{
                temp.next = newnode;
                temp = temp.next;
            }


            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }

        return head;

    }
}