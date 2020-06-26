package LeetCode.AddTwoNumbers;


// Definition for singly-linked list.

class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode result = l3;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null? 0 : l1.val);
            int val2 = (l2 == null? 0 : l2.val);
            int res = val1 + val2 + carry;
            l3.val = res % 10;
            carry = res / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if ((l1 != null) || (l2 != null) || carry != 0) {
                l3.next = new ListNode(carry);
                l3 = l3.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        // 342 + 465
        int[] ar1 = {2, 4, 3};
        int[] ar2 = {5, 6, 4};
        addTwoNumbers.addNumbers(ar1, ar2);

        // 704 + 24
        int[] ar3 = {4, 0, 7};
        int[] ar4 = {4, 2};
        addTwoNumbers.addNumbers(ar3, ar4);

        int[] ar5 = {5};
        addTwoNumbers.addNumbers(ar5, ar5);

        int[] ar6 = {1};
        int[] ar7 = {9, 9};
        addTwoNumbers.addNumbers(ar6, ar7);

    }

    void addNumbers(int[] ar1, int[] ar2) {
        ListNode l1 = createListNodeFromArray(ar1);
        ListNode l2 = createListNodeFromArray(ar2);
        ListNode res = addTwoNumbers(l1, l2);

        System.out.println(l1 + " + " + l2 + " = " + res);

    }

    ListNode createListNodeFromArray(int[] ar) {
        ListNode l1 = new ListNode();
        ListNode res = l1;
        int i = 0;
        for (i = 0; i < ar.length - 1; i++) {
            l1.val = ar[i];
            l1.next = new ListNode();
            l1 = l1.next;
        }
        l1.val = ar[i];
        return res;
    }
}