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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy=new ListNode();
        ListNode tail=dummy,l1=list1,l2=list2;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
              tail.next=l1;
              tail=l1;
              l1=l1.next;
            }else{
              tail.next=l2;
              tail=l2;
              l2=l2.next;
            }
        }
         
       if(l2!=null) tail.next=l2;
       if(l1!=null) tail.next=l1;

       return dummy.next;

        
    }
}