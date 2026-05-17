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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next; //Save next node
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

//Recursion
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) return head;

//         ListNode newHead = reverseList(head.next);

//         head.next.next = head; // reverse link
//         head.next = null;      // break original link

//         return newHead;
//     }
// }
