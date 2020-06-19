package LeetCode;


// Definition for singly-linked list.

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int left = 0;
        ListNode cur = new ListNode();
        ListNode head = cur;

        while ((l1 != null) && (l2 != null)){

            int sum = l1.val + l2.val + left;
            if (sum >= 10){
                cur.val = sum % 10;
                left = 1;
            } else {
                cur.val = sum;
                left = 0;
            }

            l1 = l1.next;
            l2 = l2.next;

            if ((l1 != null) || (l2 != null)){
                cur.next = new ListNode();
                cur = cur.next;
            }
        }

        if (l1 != null){
            cur.next = l1;
        }

        if (l2 != null){
            cur.next = l2;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}